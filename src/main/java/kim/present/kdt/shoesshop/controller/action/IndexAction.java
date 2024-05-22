package kim.present.kdt.shoesshop.controller.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.dao.ProductDao;

import java.io.IOException;

public class IndexAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao pdao = ProductDao.getInstance();

        request.setAttribute("newList", pdao.selectBestProduct());
        request.setAttribute("bestList", pdao.selectNewProduct());

        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

}
