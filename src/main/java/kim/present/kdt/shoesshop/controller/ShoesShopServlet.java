package kim.present.kdt.shoesshop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;

import java.io.IOException;

/**
 * Servlet implementation class ShoesShopServlet
 */
public class ShoesShopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        System.out.println(request.getMethod() + " : " + request.getRequestURI() + "?" + request.getQueryString());

        String command = request.getParameter("command");
        if (command == null) {
            System.out.println("1. command 값 오류");
            return;
        }

        Action ac = ActionFactory.getInstance().getAction(command);
        if (ac == null) {
            System.out.println("2. Action 조립 오류");
            return;
        }

        ac.execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
