package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.dao.AdminDao;
import kim.present.kdt.shoesshop.dto.AdminVO;

import java.io.IOException;

public class AdminProductDeleteAction extends AdminRequiredAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, AdminVO avo) throws ServletException, IOException {
        int pseq = Integer.parseInt(request.getParameter("pseq"));
        AdminDao.getInstance().deleteProduct(pseq);

        request.getRequestDispatcher("shop.do?command=adminProductList").forward(request, response);
    }
}
