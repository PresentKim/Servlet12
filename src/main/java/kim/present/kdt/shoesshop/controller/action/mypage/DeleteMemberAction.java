package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.MemberDao;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class DeleteMemberAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
        if (mvo == null) {
            response.sendRedirect("shop.do?command=loginForm");
            return;
        }

        MemberDao.getInstance().deleteMember(mvo.getUserid());
        session.removeAttribute("loginUser");
        session.setAttribute("message", "회원탈퇴가 완료되었습니다");
        response.sendRedirect("shop.do?command=loginForm");
    }

}
