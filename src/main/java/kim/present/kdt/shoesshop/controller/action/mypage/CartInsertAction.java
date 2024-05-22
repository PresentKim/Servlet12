package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.CartDao;
import kim.present.kdt.shoesshop.dto.CartVO;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class CartInsertAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pseq = Integer.parseInt(request.getParameter("pseq"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        HttpSession session = request.getSession();
        MemberVO mvo = (MemberVO) session.getAttribute("loginUser");

        if (mvo == null) {
            response.sendRedirect("shop.do?command=loginForm");
        } else {
            CartDao cdao = CartDao.getInstance();
            CartVO cvo = new CartVO();

            cvo.setUserid(mvo.getUserid());
            cvo.setPseq(pseq);
            cvo.setQuantity(quantity);

            cdao.insertCart(cvo);
            response.sendRedirect("shop.do?command=cartList");
        }
    }

}
