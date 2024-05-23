package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.MemberAction;
import kim.present.kdt.shoesshop.dao.MemberDao;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class UpdateMemberAction extends MemberAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, MemberVO mvo) throws ServletException, IOException {
        MemberVO newMvo = new MemberVO();
        newMvo.setUserid(request.getParameter("userid"));
        newMvo.setPwd(request.getParameter("pwd"));
        newMvo.setName(request.getParameter("name"));
        newMvo.setEmail(request.getParameter("email"));
        newMvo.setZip_num(request.getParameter("zip_num"));
        newMvo.setAddress1(request.getParameter("address1"));
        newMvo.setAddress2(request.getParameter("address2"));
        newMvo.setPhone(request.getParameter("phone"));

        MemberDao.getInstance().updateMember(newMvo);
        request.getSession().setAttribute("loginUser", newMvo);
        response.sendRedirect("shop.do?command=index");
    }

}
