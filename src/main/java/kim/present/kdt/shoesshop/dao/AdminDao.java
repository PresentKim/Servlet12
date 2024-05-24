package kim.present.kdt.shoesshop.dao;

import kim.present.kdt.shoesshop.dto.*;
import kim.present.kdt.shoesshop.util.Paging;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static kim.present.kdt.shoesshop.util.Db.*;

public class AdminDao {

    private AdminDao() {
    }

    private static final AdminDao instance = new AdminDao();

    public static AdminDao getInstance() {
        return instance;
    }

    public AdminVO getAdmin(String adminid) {
        return executeSelectOne("SELECT * FROM admin WHERE adminid = ?",
                pstmt -> pstmt.setString(1, adminid),
                AdminDao::extractAdminVO
        );
    }

    public List<ProductVO> adminProductList(Paging paging, String key) {
        return executeSelect("SELECT * FROM product WHERE name LIKE CONCAT('%', ? , '%') ORDER BY pseq DESC LIMIT ? OFFSET ?",
                pstmt -> {
                    pstmt.setString(1, key);
                    pstmt.setInt(2, paging.getDisplayRow());
                    pstmt.setInt(3, paging.getStartNum() - 1);
                },
                rs -> {
                    ProductVO pvo = new ProductVO();
                    pvo.setPseq(rs.getInt("pseq"));
                    pvo.setKind(rs.getString("kind"));
                    pvo.setName(rs.getString("name"));
                    pvo.setPrice1(rs.getInt("price1"));
                    pvo.setPrice2(rs.getInt("price2"));
                    pvo.setPrice3(rs.getInt("price3"));
                    pvo.setContent(rs.getString("content"));
                    pvo.setImage(rs.getString("image"));
                    pvo.setUseyn(rs.getString("useyn"));
                    pvo.setBestyn(rs.getString("bestyn"));
                    return pvo;
                }
        );
    }

    public int getAllCount(String tableName, String fieldName, String key) {
        return executeSelectOne("SELECT COUNT(*) AS cnt FROM " + tableName + " WHERE " + fieldName + " LIKE CONCAT('%', ? , '%')",
                pstmt -> pstmt.setString(1, key),
                rs -> rs.getInt("cnt")
        );
    }

    public void insertProduct(ProductVO pvo) {
        executeUpdate("INSERT INTO product( kind, name, price1, price2, price3, content, image) VALUES( ? , ? , ? , ? , ? , ? , ?)",
                pstmt -> {
                    pstmt.setString(1, pvo.getKind());
                    pstmt.setString(2, pvo.getName());
                    pstmt.setInt(3, pvo.getPrice1());
                    pstmt.setInt(4, pvo.getPrice2());
                    pstmt.setInt(5, pvo.getPrice3());
                    pstmt.setString(6, pvo.getContent());
                    pstmt.setString(7, pvo.getImage());
                }
        );
    }

    public void updateProduct(ProductVO pvo) {
        executeUpdate("UPDATE product SET kind = ?, name = ?, price1 = ?, price2 = ?, price3 = ?, content = ?, image = ?, bestyn = ? WHERE pseq = ?",
                pstmt -> {
                    pstmt.setString(1, pvo.getKind());
                    pstmt.setString(2, pvo.getName());
                    pstmt.setInt(3, pvo.getPrice1());
                    pstmt.setInt(4, pvo.getPrice2());
                    pstmt.setInt(5, pvo.getPrice3());
                    pstmt.setString(6, pvo.getContent());
                    pstmt.setString(7, pvo.getImage());
                    pstmt.setString(8, pvo.getBestyn());
                    pstmt.setInt(9, pvo.getPseq());
                }
        );
    }

    public void deleteProduct(int pseq) {
        executeUpdate("DELETE FROM product WHERE pseq = ?",
                pstmt -> pstmt.setInt(1, pseq)
        );
    }

    public List<OrderVO> adminOrderList(Paging paging, String key) {
        return executeSelect("SELECT * FROM order_view WHERE pname LIKE CONCAT('%', ? , '%') ORDER BY odseq DESC LIMIT ? OFFSET ?",
                pstmt -> {
                    pstmt.setString(1, key);
                    pstmt.setInt(2, paging.getDisplayRow());
                    pstmt.setInt(3, paging.getStartNum() - 1);
                },
                rs -> {
                    OrderVO ovo = new OrderVO();
                    ovo.setOdseq(rs.getInt("odseq"));
                    ovo.setUserid(rs.getString("userid"));
                    ovo.setPseq(rs.getInt("pseq"));
                    ovo.setQuantity(rs.getInt("quantity"));
                    ovo.setIndate(rs.getTimestamp("indate"));
                    ovo.setPrice2(rs.getInt("price2"));
                    ovo.setPname(rs.getString("pname"));
                    return ovo;
                }
        );
    }

    public void updateOrderResult(int odseq) {
        executeUpdate("UPDATE orders SET result = '1' WHERE odseq = ?",
                pstmt -> pstmt.setInt(1, odseq)
        );
    }

    public List<MemberVO> adminMemberList(Paging paging, String key) {
        return executeSelect("SELECT * FROM member WHERE userid LIKE CONCAT('%', ? , '%') ORDER BY indate DESC LIMIT ? OFFSET ?",
                pstmt -> {
                    pstmt.setString(1, key);
                    pstmt.setInt(2, paging.getDisplayRow());
                    pstmt.setInt(3, paging.getStartNum() - 1);
                },
                rs -> {
                    MemberVO mvo = new MemberVO();
                    mvo.setUserid(rs.getString("userid"));
                    mvo.setName(rs.getString("name"));
                    mvo.setPhone(rs.getString("phone"));
                    mvo.setEmail(rs.getString("email"));
                    mvo.setUseyn(rs.getString("useyn"));
                    mvo.setIndate(rs.getTimestamp("indate"));
                    return mvo;
                }
        );
    }

    public void memberChange(String userid, String useyn) {
        executeUpdate("UPDATE member SET useyn = ? WHERE userid = ?",
                pstmt -> {
                    pstmt.setString(1, useyn);
                    pstmt.setString(2, userid);
                }
        );
    }

    public List<QnaVO> adminQnaList(Paging paging, String key) {
        return executeSelect("SELECT * FROM qna WHERE subject LIKE CONCAT('%', ? , '%') ORDER BY qseq DESC LIMIT ? OFFSET ?",
                pstmt -> {
                    pstmt.setString(1, key);
                    pstmt.setInt(2, paging.getDisplayRow());
                    pstmt.setInt(3, paging.getStartNum() - 1);
                },
                rs -> {
                    QnaVO qvo = new QnaVO();
                    qvo.setQseq(rs.getInt("qseq"));
                    qvo.setSubject(rs.getString("subject"));
                    qvo.setContent(rs.getString("content"));
                    qvo.setUserid(rs.getString("userid"));
                    qvo.setIndate(rs.getTimestamp("indate"));
                    qvo.setReply(rs.getString("reply"));
                    return qvo;
                }
        );
    }

    public void updateQna(QnaVO qvo) {
        executeUpdate("UPDATE qna SET reply = ? WHERE qseq = ?",
                pstmt -> {
                    pstmt.setString(1, qvo.getReply());
                    pstmt.setInt(2, qvo.getQseq());
                }
        );
    }

    public static AdminVO extractAdminVO(ResultSet rs) throws SQLException {
        AdminVO adminVO = new AdminVO();
        adminVO.setAdminid(rs.getString("adminid"));
        adminVO.setPwd(rs.getString("pwd"));
        adminVO.setName(rs.getString("name"));
        adminVO.setPhone(rs.getString("phone"));
        return adminVO;
    }
}













