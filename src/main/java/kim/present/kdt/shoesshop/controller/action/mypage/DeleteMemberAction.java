package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kim.present.kdt.shoesshop.controller.action.MemberAction;
import kim.present.kdt.shoesshop.dao.MemberDao;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class DeleteMemberAction extends MemberAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, MemberVO mvo) throws ServletException, IOException {
        MemberDao.getInstance().deleteMember(mvo.getUserid());

        HttpSession session = request.getSession();
        session.removeAttribute("loginUser");
        session.setAttribute("message", "회원탈퇴가 완료되었습니다");

        response.sendRedirect("shop.do?command=loginForm");
    }

}
