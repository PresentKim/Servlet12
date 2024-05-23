package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.MemberAction;
import kim.present.kdt.shoesshop.dao.CartDao;
import kim.present.kdt.shoesshop.dao.OrderDao;
import kim.present.kdt.shoesshop.dto.CartVO;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderInsertAction extends MemberAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, MemberVO mvo) throws ServletException, IOException {
        CartDao cdao = CartDao.getInstance();
        String[] cseqs = request.getParameterValues("cseq");
        List<CartVO> finalList = new ArrayList<>();
        for (String cseq : cseqs) {
            CartVO cvo = cdao.getCart(cseq);
            finalList.add(cvo);
        }

        OrderDao odao = OrderDao.getInstance();
        odao.insertOrders(mvo.getUserid());

        int oseq = odao.lookupMaxOseq(mvo.getUserid());
        for (CartVO cvo : finalList) {
            odao.insertOrderDetail(cvo, oseq);
            cdao.deleteCart(cvo.getCseq());
        }

        response.sendRedirect("shop.do?command=orderList&oseq=" + oseq);
    }

}
