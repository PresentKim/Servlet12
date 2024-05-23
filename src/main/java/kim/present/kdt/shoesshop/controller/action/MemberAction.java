package kim.present.kdt.shoesshop.controller.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public abstract class MemberAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberVO mvo = (MemberVO) request.getSession().getAttribute("loginUser");
        if (mvo == null) {
            response.sendRedirect("shop.do?command=loginForm");
            return;
        }

        execute(request, response, mvo);
    }

    protected abstract void execute(HttpServletRequest request, HttpServletResponse response, MemberVO mvo) throws ServletException, IOException;

}
