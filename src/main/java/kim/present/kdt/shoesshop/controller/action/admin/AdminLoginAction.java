package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.AdminDao;
import kim.present.kdt.shoesshop.dto.AdminVO;

import java.io.IOException;

public class AdminLoginAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminid = request.getParameter("adminid");
        String pwd = request.getParameter("pwd");

        String url = "shop.do?command=admin";
        AdminDao adao = AdminDao.getInstance();
        AdminVO avo = adao.getAdmin(adminid);

        if (avo == null) {
            request.setAttribute("message", "아이디가 없습니다");
        } else if (avo.getPwd() == null) {
            request.setAttribute("message", "DB 오류. 관리자에게 문의하세요");
        } else if (!avo.getPwd().equals(pwd)) {
            request.setAttribute("message", "비밀번호가 맞지 않습니다");
        } else {
            request.getSession().setAttribute("loginAdmin", avo);
            url = "shop.do?command=adminProductList";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }

}
