package kim.present.kdt.shoesshop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Servlet implementation class ShoesShopServlet
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5
)
public class ShoesShopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        Logger logger = Logger.getLogger("Tomcat/Servlet");
        logger.info(request.getMethod() + " : " + request.getRequestURI() + "?" + request.getQueryString());

        String command = request.getParameter("command");
        if (command == null) {
            logger.warning("Command not found");
            return;
        }

        Action ac = ActionFactory.getInstance().getAction(command);
        if (ac == null) {
            logger.warning("Action not found : " + command);
            return;
        }

        ac.execute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
