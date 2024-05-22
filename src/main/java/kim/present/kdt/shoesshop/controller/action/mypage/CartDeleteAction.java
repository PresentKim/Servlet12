package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.CartDao;

import java.io.IOException;

public class CartDeleteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] cseqs = request.getParameterValues("cseq");

        CartDao cdao = CartDao.getInstance();

        for (String cseq : cseqs) {
            cdao.deleteCart(Integer.parseInt(cseq));
        }

        response.sendRedirect("shop.do?command=cartList");
    }

}
