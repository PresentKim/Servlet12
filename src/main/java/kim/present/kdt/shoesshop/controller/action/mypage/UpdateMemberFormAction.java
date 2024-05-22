package kim.present.kdt.shoesshop.controller.action.mypage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;

import java.io.IOException;

public class UpdateMemberFormAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("mypage/updateMember.jsp").forward(request, response);
    }

}
