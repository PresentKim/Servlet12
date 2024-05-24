package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dto.AdminVO;

import java.io.IOException;

public abstract class AdminRequiredAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AdminVO avo = (AdminVO) session.getAttribute("loginAdmin");
        if (avo == null) {
            response.sendRedirect("shop.do?command=admin");
            return;
        }

        execute(request, response, avo);
    }

    protected abstract void execute(HttpServletRequest request, HttpServletResponse response, AdminVO avo) throws ServletException, IOException;

}
