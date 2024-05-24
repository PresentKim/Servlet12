package kim.present.kdt.shoesshop.controller.action.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.AddressDao;

import java.io.IOException;

public class FindZipnumAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dong = request.getParameter("dong");
        if (dong != null && !dong.isEmpty()) {
            request.setAttribute("addressList", AddressDao.getInstance().selectAddressByDong(dong));
        }
        request.getRequestDispatcher("member/findZipNum.jsp").forward(request, response);
    }

}
