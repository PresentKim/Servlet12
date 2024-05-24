package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.dao.AdminDao;
import kim.present.kdt.shoesshop.dto.AdminVO;

import java.io.IOException;

public class AdminOrderSaveAction extends AdminRequiredAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, AdminVO avo) throws ServletException, IOException {
        String[] odseqs = request.getParameterValues("result");
        AdminDao adao = AdminDao.getInstance();
        for (String odseq : odseqs) {
            adao.updateOrderResult(Integer.parseInt(odseq));
        }

        request.getRequestDispatcher("shop.do?command=adminOrderList").forward(request, response);
    }

}
