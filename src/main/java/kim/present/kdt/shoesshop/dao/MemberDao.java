package kim.present.kdt.shoesshop.dao;

import kim.present.kdt.shoesshop.dto.MemberVO;

import static kim.present.kdt.shoesshop.util.Db.executeSelectOne;
import static kim.present.kdt.shoesshop.util.Db.executeUpdate;

public class MemberDao {

    private MemberDao() {
    }

    private static final MemberDao instance = new MemberDao();

    public static MemberDao getInstance() {
        return instance;
    }

    public MemberVO getMember(String userid) {
        return executeSelectOne("SELECT * FROM member WHERE userid = ?",
                pstmt -> pstmt.setString(1, userid),
                rs -> {
                    MemberVO mvo = new MemberVO();
                    mvo.setUserid(rs.getString("userid"));
                    mvo.setPwd(rs.getString("pwd"));
                    mvo.setName(rs.getString("name"));
                    mvo.setEmail(rs.getString("email"));
                    mvo.setZip_num(rs.getString("zip_num"));
                    mvo.setAddress1(rs.getString("address1"));
                    mvo.setAddress2(rs.getString("address2"));
                    mvo.setPhone(rs.getString("phone"));
                    mvo.setUseyn(rs.getString("useyn"));
                    mvo.setIndate(rs.getTimestamp("indate"));
                    return mvo;
                }
        );
    }

    public int insertMember(MemberVO mvo) {
        return executeUpdate("INSERT INTO member (userid, pwd, name, zip_num, address1, address2, email, phone)"
                        + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )",
                pstmt -> {
                    pstmt.setString(1, mvo.getUserid());
                    pstmt.setString(2, mvo.getPwd());
                    pstmt.setString(3, mvo.getName());
                    pstmt.setString(4, mvo.getZip_num());
                    pstmt.setString(5, mvo.getAddress1());
                    pstmt.setString(6, mvo.getAddress2());
                    pstmt.setString(7, mvo.getEmail());
                    pstmt.setString(8, mvo.getPhone());
                }
        );
    }

    public void updateMember(MemberVO mvo) {
        executeUpdate("UPDATE member SET pwd = ?, name = ?, zip_num = ?, address1 = ?, address2 = ?, email = ?, phone = ? WHERE userid = ?",
                pstmt -> {
                    pstmt.setString(1, mvo.getPwd());
                    pstmt.setString(2, mvo.getName());
                    pstmt.setString(3, mvo.getZip_num());
                    pstmt.setString(4, mvo.getAddress1());
                    pstmt.setString(5, mvo.getAddress2());
                    pstmt.setString(6, mvo.getEmail());
                    pstmt.setString(7, mvo.getPhone());
                    pstmt.setString(8, mvo.getUserid());
                }
        );
    }

    public void deleteMember(String userid) {
        executeUpdate("UPDATE member SET useyn = 'N' WHERE userid = ?",
                pstmt -> pstmt.setString(1, userid)
        );
    }
}













