package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.dao.AdminDao;
import kim.present.kdt.shoesshop.dto.AdminVO;
import kim.present.kdt.shoesshop.dto.QnaVO;

import java.io.IOException;

public class AdminQnaRepSaveAction extends AdminRequiredAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, AdminVO avo) throws ServletException, IOException {
        QnaVO qvo = new QnaVO();
        qvo.setQseq(Integer.parseInt(request.getParameter("qseq")));
        qvo.setReply(request.getParameter("content"));
        AdminDao.getInstance().updateQna(qvo);
        request.getRequestDispatcher("shop.do?command=adminQnaDetail&qseq=" + qvo.getQseq()).forward(request, response);
    }

}
