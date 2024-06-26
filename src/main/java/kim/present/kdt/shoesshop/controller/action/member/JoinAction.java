package kim.present.kdt.shoesshop.controller.action.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.MemberDao;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class JoinAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberVO mvo = new MemberVO();

        mvo.setUserid(request.getParameter("userid"));
        mvo.setPwd(request.getParameter("pwd"));
        mvo.setName(request.getParameter("name"));
        mvo.setEmail(request.getParameter("email"));
        mvo.setZip_num(request.getParameter("zip_num"));
        mvo.setAddress1(request.getParameter("address1"));
        mvo.setAddress2(request.getParameter("address2"));
        mvo.setPhone(request.getParameter("phone"));

        String result;
        if (MemberDao.getInstance().insertMember(mvo) == 1) {
            result = "회원가입이 완료되었습니다. 로그인하세요";
        } else {
            result = "회원가입 실패 관리자에게 문의하세요";
        }

        request.getSession().setAttribute("message", result);
        response.sendRedirect("shop.do?command=loginForm");
    }

}
