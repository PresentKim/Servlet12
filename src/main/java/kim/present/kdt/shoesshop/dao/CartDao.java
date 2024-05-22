package kim.present.kdt.shoesshop.dao;

import kim.present.kdt.shoesshop.dto.CartVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static kim.present.kdt.shoesshop.util.Db.*;

public class CartDao {

    private CartDao() {
    }

    private static final CartDao instance = new CartDao();

    public static CartDao getInstance() {
        return instance;
    }

    public void insertCart(CartVO cvo) {
        executeUpdate("INSERT INTO cart (userid, pseq, quantity) VALUES (? , ? , ?)", pstmt -> {
            pstmt.setString(1, cvo.getUserid());
            pstmt.setInt(2, cvo.getPseq());
            pstmt.setInt(3, cvo.getQuantity());
        });
    }

    public List<CartVO> selectCart(String userid) {
        return executeSelect("SELECT * FROM cart_view WHERE userid = ?",
                pstmt -> pstmt.setString(1, userid),
                CartDao::extractCartVO
        );
    }

    public void deleteCart(int cseq) {
        executeUpdate("DELETE FROM cart WHERE cseq = ?", pstmt -> pstmt.setInt(1, cseq));
    }

    public CartVO getCart(String cseq) {
        return executeSelectOne("SELECT * FROM cart_view WHERE cseq = ?",
                pstmt -> pstmt.setInt(1, Integer.parseInt(cseq)),
                CartDao::extractCartVO
        );
    }

    private static CartVO extractCartVO(ResultSet rs) throws SQLException {
        CartVO cvo = new CartVO();
        cvo.setCseq(rs.getInt("cseq"));
        cvo.setUserid(rs.getString("userid"));
        cvo.setMname(rs.getString("mname"));
        cvo.setPseq(rs.getInt("pseq"));
        cvo.setPname(rs.getString("pname"));
        cvo.setQuantity(rs.getInt("quantity"));
        cvo.setPrice2(rs.getInt("price2"));
        cvo.setIndate(rs.getTimestamp("indate"));
        return cvo;
    }

}













