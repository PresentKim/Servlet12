package kim.present.kdt.shoesshop.controller.action.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.ProductDao;

import java.io.IOException;

public class CategoryAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kind = request.getParameter("kind");
        String[] kindList = {"", "Heels", "Boots", "Sandals", "Snickers", "Slippers"};

        request.setAttribute("kindProduct", ProductDao.getInstance().selectKindProduct(kind));
        request.setAttribute("kind", kindList[Integer.parseInt(kind)]);
        request.getRequestDispatcher("product/productKind.jsp").forward(request, response);
    }

}





