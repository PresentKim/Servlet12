package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.MemberAction;
import kim.present.kdt.shoesshop.dao.OrderDao;
import kim.present.kdt.shoesshop.dto.MemberVO;
import kim.present.kdt.shoesshop.dto.OrderVO;

import java.io.IOException;
import java.util.List;

public class OrderDetailAction extends MemberAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, MemberVO mvo) throws ServletException, IOException {
        int oseq = Integer.parseInt(request.getParameter("oseq"));
        List<OrderVO> list = OrderDao.getInstance().selectOrderByOseq(oseq);
        request.setAttribute("orderList", list);
        request.setAttribute("orderDetail", list.get(0));

        int totalPrice = 0;
        for (OrderVO ovo : list) {
            totalPrice += ovo.getPrice2() * ovo.getQuantity();
        }

        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("mypage/orderDetail.jsp").forward(request, response);
    }

}
