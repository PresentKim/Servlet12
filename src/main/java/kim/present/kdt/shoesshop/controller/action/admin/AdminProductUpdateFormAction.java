package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.dao.ProductDao;
import kim.present.kdt.shoesshop.dto.AdminVO;
import kim.present.kdt.shoesshop.dto.ProductVO;

import java.io.IOException;

public class AdminProductUpdateFormAction extends AdminRequiredAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, AdminVO avo) throws ServletException, IOException {
        int pseq = Integer.parseInt(request.getParameter("pseq"));
        ProductVO pvo = ProductDao.getInstance().getProduct(pseq);
        request.setAttribute("productVO", pvo);

        String[] kindList = {"Heels", "Boots", "Sandals", "Snickers", "Slippers", "Sale"};
        int index = Integer.parseInt(pvo.getKind());

        request.setAttribute("kindList", kindList);
        request.setAttribute("kind", kindList[index]);

        request.getRequestDispatcher("admin/product/productUpdate.jsp").forward(request, response);
    }

}
