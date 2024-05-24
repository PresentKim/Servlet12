package kim.present.kdt.shoesshop.controller.action.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kim.present.kdt.shoesshop.controller.action.MemberAction;
import kim.present.kdt.shoesshop.dao.QnaDao;
import kim.present.kdt.shoesshop.dto.MemberVO;
import kim.present.kdt.shoesshop.util.Paging;

import java.io.IOException;

public class QnaListAction extends MemberAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, MemberVO mvo) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
            session.setAttribute("page", page);
        } else if (session.getAttribute("page") != null) {
            page = (Integer) session.getAttribute("page");
        }

        QnaDao qdao = QnaDao.getInstance();
        Paging paging = new Paging();
        paging.setPage(page);
        paging.setTotalCount(qdao.getAllCount());

        request.setAttribute("paging", paging);
        request.setAttribute("qnaList", qdao.selectQna(paging));
        request.getRequestDispatcher("customer/qnaList.jsp").forward(request, response);
    }

}
