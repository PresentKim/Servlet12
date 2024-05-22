package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.CartDao;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class CartDeleteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberVO mvo = (MemberVO) request.getSession().getAttribute("loginUser");
        if (mvo == null) {
            response.sendRedirect("shop.do?command=loginForm");
            return;
        }

        CartDao cdao = CartDao.getInstance();
        for (String cseq : request.getParameterValues("cseq")) {
            cdao.deleteCart(Integer.parseInt(cseq));
        }

        response.sendRedirect("shop.do?command=cartList");
    }

}
