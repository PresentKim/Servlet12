package kim.present.kdt.shoesshop.controller.action.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kim.present.kdt.shoesshop.controller.action.Action;
import kim.present.kdt.shoesshop.dao.MemberDao;
import kim.present.kdt.shoesshop.dto.AddressVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindZipnumAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dong = request.getParameter("dong");
        if (dong != null && !dong.isEmpty()) {
            MemberDao mdao = MemberDao.getInstance();
            List<AddressVO> list = mdao.selectAddressByDong(dong);
            request.setAttribute("addressList", list);
        }
        request.getRequestDispatcher("member/findZipNum.jsp").forward(request, response);
    }

}
