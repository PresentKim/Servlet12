package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.dao.QnaDao;
import kim.present.kdt.shoesshop.dto.AdminVO;
import kim.present.kdt.shoesshop.dto.QnaVO;

import java.io.IOException;

public class AdminQnaDetailAction extends AdminRequiredAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, AdminVO avo) throws ServletException, IOException {
        String qseq = request.getParameter("qseq");
        QnaVO qvo = QnaDao.getInstance().getQna(Integer.parseInt(qseq));

        request.setAttribute("qnaVO", qvo);
        request.getRequestDispatcher("admin/qna/qnaDetail.jsp").forward(request, response);
    }

}
