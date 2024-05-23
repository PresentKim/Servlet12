package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.MemberAction;
import kim.present.kdt.shoesshop.dao.CartDao;
import kim.present.kdt.shoesshop.dto.CartVO;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;
import java.util.List;

public class CartListAction extends MemberAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, MemberVO mvo) throws ServletException, IOException {
        List<CartVO> list = CartDao.getInstance().selectCart(mvo.getUserid());
        int totalPrice = 0;
        for (CartVO cvo : list) {
            totalPrice += cvo.getPrice2() * cvo.getQuantity();
        }

        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("cartList", list);
        request.getRequestDispatcher("mypage/cartList.jsp").forward(request, response);
    }

}
