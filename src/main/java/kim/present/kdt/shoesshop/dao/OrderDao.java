package kim.present.kdt.shoesshop.dao;

import kim.present.kdt.shoesshop.dto.CartVO;
import kim.present.kdt.shoesshop.dto.OrderVO;

import java.util.List;

import static kim.present.kdt.shoesshop.util.Db.executeSelect;
import static kim.present.kdt.shoesshop.util.Db.executeUpdate;

public class OrderDao {

    private OrderDao() {
    }

    private static final OrderDao instance = new OrderDao();

    public static OrderDao getInstance() {
        return instance;
    }

    public void insertOrders(String userid) {
        executeUpdate("INSERT INTO orders (userid) VALUES (?)", pstmt -> pstmt.setString(1, userid));
    }

    public int lookupMaxOseq(String userid) {
        return executeSelect("SELECT MAX(oseq) AS moseq FROM orders WHERE userid = ?",
                pstmt -> pstmt.setString(1, userid),
                rs -> rs.getInt("moseq")
        ).get(0);
    }

    public void insertOrderDetail(CartVO cvo, int oseq) {
        executeUpdate("INSERT INTO order_detail( oseq, pseq, quantity ) VALUES(?, ?, ?)",
                pstmt -> {
                    pstmt.setInt(1, oseq);
                    pstmt.setInt(2, cvo.getPseq());
                    pstmt.setInt(3, cvo.getQuantity());
                }
        );
    }

    public List<OrderVO> selectOrderByOseq(int oseq) {
        return executeSelect("SELECT * FROM order_view WHERE oseq = ?",
                pstmt -> pstmt.setInt(1, oseq),
                rs -> {
                    OrderVO ovo = new OrderVO();
                    ovo.setOdseq(rs.getInt("odseq"));
                    ovo.setOseq(rs.getInt("oseq"));
                    ovo.setUserid(rs.getString("userid"));
                    ovo.setIndate(rs.getTimestamp("indate"));
                    ovo.setMname(rs.getString("mname"));
                    ovo.setZip_num(rs.getString("zip_num"));
                    ovo.setAddress1(rs.getString("address1"));
                    ovo.setAddress2(rs.getString("address2"));
                    ovo.setPhone(rs.getString("phone"));
                    ovo.setPname(rs.getString("pname"));
                    ovo.setPrice2(rs.getInt("price2"));
                    ovo.setPseq(rs.getInt("pseq"));
                    ovo.setQuantity(rs.getInt("quantity"));
                    ovo.setResult(rs.getString("result"));
                    return ovo;
                }
        );
    }

    public void insertOrderDetail(int pseq, int quantity, int oseq) {
        executeUpdate("INSERT INTO order_detail( oseq, pseq, quantity ) VALUES(?, ?, ?)",
                pstmt -> {
                    pstmt.setInt(1, oseq);
                    pstmt.setInt(2, pseq);
                    pstmt.setInt(3, quantity);
                }
        );
    }

}











