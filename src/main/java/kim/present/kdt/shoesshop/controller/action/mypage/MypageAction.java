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

public class MypageAction extends MemberAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, MemberVO mvo) throws ServletException, IOException {
        ArrayList<OrderVO> finalList = new ArrayList<>();

        OrderDao odao = OrderDao.getInstance();
        List<Integer> oseqList = odao.selectOseqOrderIng(mvo.getUserid());

        for (Integer oseq : oseqList) {
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

        request.setAttribute("finalList", finalList);
        request.setAttribute("title", "진행중인 주문내역");
        request.getRequestDispatcher("mypage/mypage.jsp").forward(request, response);
    }

}
