package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kim.present.kdt.shoesshop.dto.AdminVO;

import java.io.IOException;

public class AdminProductWriteFormAction extends AdminRequiredAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, AdminVO avo) throws ServletException, IOException {
        String[] kindList = {"Heels", "Boots", "Sandals", "Snickers", "Slippers", "On Sale"};
        request.setAttribute("kindList", kindList);
        request.getRequestDispatcher("admin/product/productWrite.jsp").forward(request, response);
    }

}
