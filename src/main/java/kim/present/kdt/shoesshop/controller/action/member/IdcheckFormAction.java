package kim.present.kdt.shoesshop.controller.action.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.MemberDao;
import kim.present.kdt.shoesshop.dto.MemberVO;

import java.io.IOException;

public class IdcheckFormAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        MemberVO mvo = MemberDao.getInstance().getMember(userid);

        request.setAttribute("userid", userid);
        request.setAttribute("result", mvo == null ? -1 : 1);
        request.getRequestDispatcher("member/idcheck.jsp").forward(request, response);
    }

}
