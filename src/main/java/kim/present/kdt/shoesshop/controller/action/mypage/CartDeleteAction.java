package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.MemberAction;
import kim.present.kdt.shoesshop.dao.CartDao;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class CartDeleteAction extends MemberAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, MemberVO mvo) throws ServletException, IOException {
        CartDao cdao = CartDao.getInstance();
        for (String cseq : request.getParameterValues("cseq")) {
            cdao.deleteCart(Integer.parseInt(cseq));
        }

        response.sendRedirect("shop.do?command=cartList");
    }

}
