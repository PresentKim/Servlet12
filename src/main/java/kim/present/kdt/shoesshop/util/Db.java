package kim.present.kdt.shoesshop.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Db {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/MysqlDB/shop");
            con = ds.getConnection();
        } catch (NamingException | SQLException e) {
            Logger.getLogger("DB").throwing("Db", "getConnection", e);
        }
        return con;
    }

    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (con != null) con.close();
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
        } catch (SQLException e) {
            Logger.getLogger("DB").throwing("Db", "close", e);
        }
    }

    public static int executeUpdate(String query, StatementPreparer preparer) {
        int result = 0;
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);

            preparer.prepare(pstmt);
            result = pstmt.executeUpdate();

            close(con, pstmt, null);
        } catch (SQLException e) {
            Logger.getLogger("DB").throwing("Db", "execute", e);
        }

        return result;
    }

    public static <T> List<T> executeSelect(String query, ResultSetExtractor<T> extractor) {
        return executeSelect(query, pstmt -> {
        }, extractor);
    }

    public static <T> List<T> executeSelect(String query, StatementPreparer preparer, ResultSetExtractor<T> extractor) {
        List<T> list = new ArrayList<>();
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);

            preparer.prepare(pstmt);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(extractor.extract(rs));
            }

            close(con, pstmt, rs);
        } catch (SQLException e) {
            Logger.getLogger("DB").throwing("Db", "execute", e);
        }

        return list;
    }

    public static <T> T executeSelectOne(String query, StatementPreparer preparer, ResultSetExtractor<T> extractor) {
        T result = null;
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);

            preparer.prepare(pstmt);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = extractor.extract(rs);
            }

            close(con, pstmt, rs);
        } catch (SQLException e) {
            Logger.getLogger("DB").throwing("Db", "execute", e);
        }

        return result;
    }

    @FunctionalInterface
    public interface StatementPreparer {
        void prepare(PreparedStatement pstmt) throws SQLException;
    }

    @FunctionalInterface
    public interface ResultSetExtractor<T> {
        T extract(ResultSet rs) throws SQLException;
    }

}
