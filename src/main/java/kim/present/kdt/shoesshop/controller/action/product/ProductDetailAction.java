package kim.present.kdt.shoesshop.controller.action.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.ProductDao;

import java.io.IOException;

public class ProductDetailAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pseq = Integer.parseInt(request.getParameter("pseq"));

        request.setAttribute("productVO", ProductDao.getInstance().getProduct(pseq));

        request.getRequestDispatcher("product/productDetail.jsp").forward(request, response);
    }

}
