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

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoesShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String command = request.getParameter("command");
        System.out.println("command : " + command);
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

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
