package kim.present.kdt.shoesshop.controller.action.member;

import java.io.IOException;

import kim.present.kdt.shoesshop.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("member/joinForm.jsp").forward(request, response);
	}

}
