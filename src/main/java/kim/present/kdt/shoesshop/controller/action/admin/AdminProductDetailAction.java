package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.dao.ProductDao;
import kim.present.kdt.shoesshop.dto.AdminVO;
import kim.present.kdt.shoesshop.dto.ProductVO;

import java.io.IOException;

public class AdminProductDetailAction extends AdminRequiredAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, AdminVO avo) throws ServletException, IOException {
        int pseq = Integer.parseInt(request.getParameter("pseq"));
        ProductVO pvo = ProductDao.getInstance().getProduct(pseq);

        String[] kindList = {"", "Heels", "Boots", "Sandals", "Snickers", "Slippers", "On Sale"};
        int index = Integer.parseInt(pvo.getKind());

        request.setAttribute("kind", kindList[index]);
        request.setAttribute("productVO", pvo);

        request.getRequestDispatcher("admin/product/productDetail.jsp").forward(request, response);
    }

}
