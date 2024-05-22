package kim.present.kdt.shoesshop.controller.action.customer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.QnaDao;
import kim.present.kdt.shoesshop.dto.MemberVO;
import kim.present.kdt.shoesshop.util.Paging;

import java.io.IOException;

public class QnaListAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberVO mvo = (MemberVO) request.getSession().getAttribute("loginUser");
        if (mvo == null) {
            response.sendRedirect("shop.do?command=loginForm");
            return;
        }

        int page = 1;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        QnaDao qdao = QnaDao.getInstance();
        Paging paging = new Paging();
        paging.setPage(page);
        paging.setDisplayPage(5);
        paging.setDisplayRow(5);
        paging.setTotalCount(qdao.getAllCount());

        request.setAttribute("paging", paging);
        request.setAttribute("qnaList", qdao.selectQna(paging));
        request.getRequestDispatcher("customer/qnaList.jsp").forward(request, response);

    }

}
