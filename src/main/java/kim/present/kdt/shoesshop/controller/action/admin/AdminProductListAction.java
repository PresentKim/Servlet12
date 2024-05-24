package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kim.present.kdt.shoesshop.dao.AdminDao;
import kim.present.kdt.shoesshop.dto.AdminVO;
import kim.present.kdt.shoesshop.util.Paging;

import java.io.IOException;

public class AdminProductListAction extends AdminRequiredAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, AdminVO avo) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (request.getParameter("first") != null) {
            session.removeAttribute("page");
            session.removeAttribute("key");
        }

        Paging paging = new Paging();
        if (request.getParameter("page") != null) {
            paging.setPage(Integer.parseInt(request.getParameter("page")));
            session.setAttribute("page", Integer.parseInt(request.getParameter("page")));
        } else if (session.getAttribute("page") != null) {
            paging.setPage((Integer) session.getAttribute("page"));
        } else {
            paging.setPage(1);
            session.removeAttribute("page");
        }

        String key;
        if (request.getParameter("key") != null) {
            key = request.getParameter("key");
            session.setAttribute("key", key);
        } else if (session.getAttribute("key") != null) {
            key = (String) session.getAttribute("key");
        } else {
            key = "";
            session.removeAttribute("key");
        }

        AdminDao adao = AdminDao.getInstance();
        int count = adao.getAllCount("product", "name", key);
        paging.setTotalCount(count);

        request.setAttribute("productList", adao.adminProductList(paging, key));
        request.setAttribute("paging", paging);
        request.setAttribute("key", key);

        request.getRequestDispatcher("admin/product/productList.jsp").forward(request, response);
    }

}
