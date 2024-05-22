package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.OrderDao;
import kim.present.kdt.shoesshop.dto.MemberVO;
import kim.present.kdt.shoesshop.dto.OrderVO;

import java.io.IOException;
import java.util.List;

public class OrderListAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberVO mvo = (MemberVO) request.getSession().getAttribute("loginUser");
        if (mvo == null) {
            response.sendRedirect("shop.do?command=loginForm");
            return;
        }

        //  order_view 에서 주문번호(oseq)로 주문을 검색하고 request 에 담아서 orderList.jsp 로 이동
        OrderDao odao = OrderDao.getInstance();
        int oseq = Integer.parseInt(request.getParameter("oseq"));
        List<OrderVO> list = odao.selectOrderByOseq(oseq);
        request.setAttribute("orderList", list);

        int totalPrice = 0;
        for (OrderVO ovo : list)  // 조회된 주문의 총 결제금액 계산
            totalPrice += (ovo.getPrice2() * ovo.getQuantity());

        request.setAttribute("totalPrice", totalPrice);
        request.getRequestDispatcher("mypage/orderList.jsp").forward(request, response);
    }
}









