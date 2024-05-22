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
        MemberDao mdao = MemberDao.getInstance();
        MemberVO mvo = mdao.getMember(userid);

        if (mvo == null) request.setAttribute("result", -1); //사용가능
        else request.setAttribute("result", 1);  //사용중

        request.setAttribute("userid", userid);

        request.getRequestDispatcher("member/idcheck.jsp").forward(request, response);
    }

}
