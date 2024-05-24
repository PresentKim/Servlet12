package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.dao.AdminDao;
import kim.present.kdt.shoesshop.dto.AdminVO;

import java.io.IOException;

public class MemberChangeNAction extends AdminRequiredAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, AdminVO avo) throws ServletException, IOException {
        String userid = request.getParameter("userid");

        AdminDao.getInstance().memberChange(userid, "N");
        request.getRequestDispatcher("shop.do?command=adminMemberList").forward(request, response);
    }

}
