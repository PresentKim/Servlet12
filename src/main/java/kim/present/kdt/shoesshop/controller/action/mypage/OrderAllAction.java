package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.MemberAction;
import kim.present.kdt.shoesshop.dao.OrderDao;
import kim.present.kdt.shoesshop.dto.MemberVO;
import kim.present.kdt.shoesshop.dto.OrderVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderAllAction extends MemberAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, MemberVO mvo) throws ServletException, IOException {
        request.setAttribute("finalList", getFinalList(mvo));
        request.setAttribute("title", "총 주문 내역");
        request.getRequestDispatcher("mypage/mypage.jsp").forward(request, response);
    }

    private static List<OrderVO> getFinalList(MemberVO mvo) {
        List<OrderVO> finalList = new ArrayList<>();
        OrderDao odao = OrderDao.getInstance();

        for (Integer oseq : odao.selectOseqOrderAll(mvo.getUserid())) {
            List<OrderVO> orderListByOseq = odao.selectOrderByOseq(oseq);
            OrderVO temp = orderListByOseq.get(0);
            temp.setPname(temp.getPname() + " 포함 " + orderListByOseq.size() + "건");
            int totalPrice = 0;
            for (OrderVO ovo : orderListByOseq) {
                totalPrice += ovo.getPrice2() * ovo.getQuantity();
            }
            temp.setPrice2(totalPrice);
            finalList.add(temp);
        }
        return finalList;
    }

}
