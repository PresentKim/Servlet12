package kim.present.kdt.shoesshop.dao;

import kim.present.kdt.shoesshop.dto.QnaVO;
import kim.present.kdt.shoesshop.util.Paging;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static kim.present.kdt.shoesshop.util.Db.*;

public class QnaDao {

    private QnaDao() {
    }

    private static final QnaDao instance = new QnaDao();

    public static QnaDao getInstance() {
        return instance;
    }

    public List<QnaVO> selectQna(Paging paging) {
        return executeSelect("SELECT * FROM qna ORDER BY qseq DESC LIMIT ? OFFSET ?",
                pstmt -> {
                    pstmt.setInt(1, paging.getDisplayRow());
                    pstmt.setInt(2, paging.getStartNum() - 1);
                },
                QnaDao::extractQnaVO
        );
    }

    public QnaVO getQna(int qseq) {
        return executeSelectOne("SELECT * FROM qna WHERE qseq = ?",
                pstmt -> pstmt.setInt(1, qseq),
                QnaDao::extractQnaVO
        );
    }

    public void insertQna(QnaVO qvo) {
        executeUpdate("INSERT INTO qna (subject, content, userid) VALUES (?, ?, ?)",
                pstmt -> {
                    pstmt.setString(1, qvo.getSubject());
                    pstmt.setString(2, qvo.getContent());
                    pstmt.setString(3, qvo.getUserid());
                }
        );
    }

    public int getAllCount() {
        return executeSelectOne("SELECT COUNT(*) AS cnt FROM qna", rs -> rs.getInt("cnt"));
    }

    private static QnaVO extractQnaVO(ResultSet rs) throws SQLException {
        QnaVO qvo = new QnaVO();
        qvo.setQseq(rs.getInt("qseq"));
        qvo.setSubject(rs.getString("subject"));
        qvo.setContent(rs.getString("content"));
        qvo.setUserid(rs.getString("userid"));
        qvo.setIndate(rs.getTimestamp("indate"));
        qvo.setReply(rs.getString("reply"));
        return qvo;
    }

}







