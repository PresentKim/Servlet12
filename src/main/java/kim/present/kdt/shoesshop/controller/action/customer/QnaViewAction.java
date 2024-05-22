package kim.present.kdt.shoesshop.controller.action.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.QnaDao;

import java.io.IOException;

public class QnaViewAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int qseq = Integer.parseInt(request.getParameter("qseq"));
        request.setAttribute("qnaVO", QnaDao.getInstance().getQna(qseq));
        request.getRequestDispatcher("customer/qnaView.jsp").forward(request, response);
    }

}
