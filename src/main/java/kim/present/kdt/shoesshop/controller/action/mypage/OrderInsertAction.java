package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.CartDao;
import kim.present.kdt.shoesshop.dao.OrderDao;
import kim.present.kdt.shoesshop.dto.CartVO;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderInsertAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberVO mvo = (MemberVO) request.getSession().getAttribute("loginUser");
        if (mvo == null) {
            response.sendRedirect("shop.do?command=loginForm");
            return;
        }

        // 1. 장바구니의 물건을 일관주문할때 -> 아이디로 장바구니를 검색
        CartDao cdao = CartDao.getInstance();
        List<CartVO> list1 = cdao.selectCart(mvo.getUserid());

        // 2. 장바구니의 선택한 물건만 주문할때 -> 전송된  cseq 들로 검색
        String[] cseqs = request.getParameterValues("cseq");
        List<CartVO> list2 = new ArrayList<>();
        for (String cseq : cseqs) {
            CartVO cvo = cdao.getCart(cseq);
            list2.add(cvo);
        }

        // 1. orders 테이블에 로그인 유저의 아이디로 레코드를 추가
        OrderDao odao = OrderDao.getInstance();
        odao.insertOrders(mvo.getUserid());

        // 2. 방금 orders 테이블에 추가된  레코드의  oseq 를 조회
        int oseq = odao.lookupMaxOseq(mvo.getUserid());

        // 3. list2에 있는 물건들과  oseq 를 이용해서  order_detail 테이블에 레코드를 추가
        // 4. 주문된 cart 내역은 cart 테이블에서 삭제
        for (CartVO cvo : list2) {
            odao.insertOrderDetail(cvo, oseq);
            cdao.deleteCart(cvo.getCseq());
        }

        // 5. 방금 주문에 성공한 주문 번호를 갖고  주문 내역을 다시 조회해서 jsp로 이동합니다
        response.sendRedirect("shop.do?command=orderList&oseq=" + oseq);
    }

}
