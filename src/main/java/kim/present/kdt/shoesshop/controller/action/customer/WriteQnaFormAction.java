package kim.present.kdt.shoesshop.controller.action.customer;

import java.io.IOException;

import  kim.present.kdt.shoesshop.controller.action.Action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class WriteQnaFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("customer/writeQnaForm.jsp").forward(request, response);
	}

}
