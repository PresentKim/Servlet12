package kim.present.kdt.shoesshop.controller.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.dao.ProductDao;
import kim.present.kdt.shoesshop.dto.ProductVO;

import java.io.IOException;
import java.util.ArrayList;

public class IndexAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao pdao = ProductDao.getInstance();
        ArrayList<ProductVO> blist = pdao.bestList();
        ArrayList<ProductVO> nlist = pdao.newList();

        request.setAttribute("newList", nlist);
        request.setAttribute("bestList", blist);

        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

}
