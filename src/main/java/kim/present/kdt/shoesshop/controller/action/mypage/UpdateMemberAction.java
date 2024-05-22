package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.MemberDao;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class UpdateMemberAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("loginUser") == null) {
            response.sendRedirect("shop.do?command=loginForm");
            return;
        }

        MemberVO mvo = new MemberVO();
        mvo.setUserid(request.getParameter("userid"));
        mvo.setPwd(request.getParameter("pwd"));
        mvo.setName(request.getParameter("name"));
        mvo.setEmail(request.getParameter("email"));
        mvo.setZip_num(request.getParameter("zip_num"));
        mvo.setAddress1(request.getParameter("address1"));
        mvo.setAddress2(request.getParameter("address2"));
        mvo.setPhone(request.getParameter("phone"));

        MemberDao.getInstance().updateMember(mvo);
        session.setAttribute("loginUser", mvo);
        response.sendRedirect("shop.do?command=index");
    }

}
