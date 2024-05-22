package kim.present.kdt.shoesshop.controller.action.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.ProductDao;
import kim.present.kdt.shoesshop.dto.ProductVO;

import java.io.IOException;

public class ProductDetailAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pseq = Integer.parseInt(request.getParameter("pseq"));

        ProductDao pdao = ProductDao.getInstance();
        ProductVO pvo = pdao.getProduct(pseq);

        request.setAttribute("productVO", pvo);

        request.getRequestDispatcher("product/productDetail.jsp").forward(request, response);
    }

}
