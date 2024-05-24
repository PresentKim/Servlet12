package kim.present.kdt.shoesshop.controller.action.admin;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import kim.present.kdt.shoesshop.dao.AdminDao;
import kim.present.kdt.shoesshop.dto.AdminVO;
import kim.present.kdt.shoesshop.dto.ProductVO;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class AdminProductUpdateAction extends AdminRequiredAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, AdminVO avo) throws ServletException, IOException {
        ProductVO pvo = new ProductVO();
        pvo.setPseq(Integer.parseInt(request.getParameter("pseq")));
        pvo.setKind(request.getParameter("kind"));
        pvo.setName(request.getParameter("name"));
        pvo.setPrice1(Integer.parseInt(request.getParameter("price1")));
        pvo.setPrice2(Integer.parseInt(request.getParameter("price2")));
        pvo.setPrice3(Integer.parseInt(request.getParameter("price3")));
        pvo.setContent(request.getParameter("content"));
        pvo.setUseyn(request.getParameter("useyn"));
        pvo.setBestyn(request.getParameter("bestyn"));

        HttpSession session = request.getSession();
        ServletContext context = session.getServletContext();
        String uploadFilePath = context.getRealPath("product_images");

        File uploadDir = new File(uploadFilePath);
        if (!uploadDir.exists() && !uploadDir.mkdirs()) {
            throw new IOException("Failed to create directory: " + uploadDir.getAbsolutePath());
        }

        for (Part p : request.getParts()) {
            String fileName = "";
            for (String content : p.getHeader("content-disposition").split(";")) {
                if (content.trim().startsWith("filename"))
                    fileName = content.substring(content.indexOf("=") + 2, content.length() - 1);
            }

            if (!fileName.isEmpty()) {
                Calendar today = Calendar.getInstance();
                long dt = today.getTimeInMillis();
                String fn1 = fileName.substring(0, fileName.indexOf("."));
                String fn2 = fileName.substring(fileName.indexOf("."));
                String saveFilename = fn1 + dt + fn2;
                p.write(uploadFilePath + File.separator + saveFilename);

                pvo.setImage(fileName);
                pvo.setSavefilename(saveFilename);
            }
        }

        AdminDao.getInstance().updateProduct(pvo);
        request.getRequestDispatcher("shop.do?command=adminProductDetail&pseq=" + pvo.getPseq()).forward(request, response);
        request.getRequestDispatcher("shop.do?command=adminProductDetail&pseq=none").forward(request, response);
    }
}
