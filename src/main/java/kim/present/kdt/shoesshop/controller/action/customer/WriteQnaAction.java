package kim.present.kdt.shoesshop.controller.action.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.QnaDao;
import kim.present.kdt.shoesshop.dto.QnaVO;

import java.io.IOException;

public class WriteQnaAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QnaVO qvo = new QnaVO();
        qvo.setUserid(request.getParameter("userid"));
        qvo.setSubject(request.getParameter("subject"));
        qvo.setContent(request.getParameter("content"));

        QnaDao.getInstance().insertQna(qvo);
        response.sendRedirect("shop.do?command=qnaList");
    }

}
