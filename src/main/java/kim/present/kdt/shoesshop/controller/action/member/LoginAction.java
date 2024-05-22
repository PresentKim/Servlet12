package kim.present.kdt.shoesshop.controller.action.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.MemberDao;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class LoginAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String pwd = request.getParameter("pwd");

        MemberVO mvo = MemberDao.getInstance().getMember(userid);

        String url = "member/loginForm.jsp";
        if (mvo == null) {
            request.setAttribute("message", "아이디가 없습니다");
        } else if (!mvo.getPwd().equals(pwd)) {
            request.setAttribute("message", "패스워드가 틀립니다");
        } else {
            url = "shop.do?command=index";
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", mvo);
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

}
