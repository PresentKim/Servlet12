package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.MemberAction;
import kim.present.kdt.shoesshop.dao.CartDao;
import kim.present.kdt.shoesshop.dto.CartVO;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class CartInsertAction extends MemberAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, MemberVO mvo) throws ServletException, IOException {
        int pseq = Integer.parseInt(request.getParameter("pseq"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        CartVO cvo = new CartVO();
        cvo.setUserid(mvo.getUserid());
        cvo.setPseq(pseq);
        cvo.setQuantity(quantity);

        CartDao.getInstance().insertCart(cvo);
        response.sendRedirect("shop.do?command=cartList");
    }

}
