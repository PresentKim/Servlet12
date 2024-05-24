package kim.present.kdt.shoesshop.dao;

import kim.present.kdt.shoesshop.dto.AddressVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static kim.present.kdt.shoesshop.util.Db.executeSelect;

public class AddressDao {

    private AddressDao() {
    }

    private static final AddressDao instance = new AddressDao();

    public static AddressDao getInstance() {
        return instance;
    }

    public List<AddressVO> selectAddressByDong(String dong) {
        return executeSelect("SELECT * FROM address WHERE dong LIKE CONCAT('%', ?, '%')",
                pstmt -> pstmt.setString(1, dong),
                AddressDao::extractAddressVO
        );
    }

    private static AddressVO extractAddressVO(ResultSet rs) throws SQLException {
        AddressVO avo = new AddressVO();
        avo.setZip_num(rs.getString("zip_num"));
        avo.setSido(rs.getString("sido"));
        avo.setGugun(rs.getString("gugun"));
        avo.setDong(rs.getString("dong"));
        avo.setZip_code(rs.getString("zip_code"));
        avo.setBunji(rs.getString("bunji"));
        return avo;
    }
}













