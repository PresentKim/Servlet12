package kim.present.kdt.shoesshop.dao;

import kim.present.kdt.shoesshop.dto.ProductVO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static kim.present.kdt.shoesshop.util.Db.executeSelect;
import static kim.present.kdt.shoesshop.util.Db.executeSelectOne;

public class ProductDao {

    private ProductDao() {
    }

    private static final ProductDao instance = new ProductDao();

    public static ProductDao getInstance() {
        return instance;
    }

    public List<ProductVO> selectBestProduct() {
        return executeSelect("SELECT * FROM best_pro_view", ProductDao::extractProductVO);
    }

    public List<ProductVO> selectNewProduct() {
        return executeSelect("SELECT * FROM new_pro_view", ProductDao::extractProductVO);
    }

    public List<ProductVO> selectKindProduct(String kind) {
        return executeSelect("SELECT * FROM product WHERE kind = ?",
                pstmt -> pstmt.setString(1, kind),
                ProductDao::extractProductVO
        );
    }

    public ProductVO getProduct(int pseq) {
        return executeSelectOne("SELECT * FROM product WHERE pseq = ?",
                pstmt -> pstmt.setInt(1, pseq),
                ProductDao::extractProductVO
        );
    }

    private static ProductVO extractProductVO(ResultSet rs) throws SQLException {
        ProductVO pvo = new ProductVO();
        pvo.setPseq(rs.getInt("pseq"));
        pvo.setName(rs.getString("name"));
        pvo.setPrice2(rs.getInt("price2"));
        pvo.setImage(rs.getString("image"));
        pvo.setSavefilename(rs.getString("savefilename"));
        return pvo;
    }

}
