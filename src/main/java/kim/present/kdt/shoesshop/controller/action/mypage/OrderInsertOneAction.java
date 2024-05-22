package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.OrderDao;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class OrderInsertOneAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberVO mvo = (MemberVO) request.getSession().getAttribute("loginUser");
        if (mvo == null) {
            response.sendRedirect("shop.do?command=loginForm");
            return;
        }

        int pseq = Integer.parseInt(request.getParameter("pseq"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        OrderDao odao = OrderDao.getInstance();
        odao.insertOrders(mvo.getUserid());

        int oseq = odao.lookupMaxOseq(mvo.getUserid());
        odao.insertOrderDetail(pseq, quantity, oseq);

        response.sendRedirect("shop.do?command=orderList&oseq=" + oseq);
    }

}
