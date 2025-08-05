package poly.quanan.dao.impl;

import java.util.List;
import poly.quanan.dao.LoaiMonAnDAO;
import poly.quanan.entity.Drink;
import poly.quanan.entity.LoaiMonAn;
import poly.quanan.util.XJdbc;
import poly.quanan.util.XQuery;

public class LoaiMonAnDAOImpl implements LoaiMonAnDAO {

    private static final String INSERT_SQL = 
        "INSERT INTO Category(MaDanhMuc, TenDanhMuc) VALUES(?, ?)";
    private static final String UPDATE_SQL = 
        "UPDATE Category SET TenDanhMuc=? WHERE MaDanhMuc=?";
    private static final String DELETE_SQL = 
        "DELETE FROM Category WHERE MaDanhMuc=?";
    private static final String SELECT_ALL_SQL = 
        "SELECT * FROM Category";
    private static final String SELECT_BY_ID_SQL = 
        "SELECT * FROM Category WHERE MaDanhMuc=?";
    private static final String SELECT_DRINK_BY_CATEGORY_SQL = 
        "SELECT * FROM Drink WHERE DrinkId=?";

    @Override
    public LoaiMonAn create(LoaiMonAn entity) {
        XJdbc.executeUpdate(
            INSERT_SQL, 
            entity.getMaDanhMuc(), 
            entity.getTenDanhMuc()
        );
        return entity;
    }

    @Override
    public void update(LoaiMonAn entity) {
        XJdbc.executeUpdate(
            UPDATE_SQL, 
            entity.getTenDanhMuc(), 
            entity.getMaDanhMuc()
        );
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<LoaiMonAn> findAll() {
        return XQuery.getBeanList(LoaiMonAn.class, SELECT_ALL_SQL);
    }

    @Override
    public LoaiMonAn findById(String id) {
        return XQuery.getSingleBean(LoaiMonAn.class, SELECT_BY_ID_SQL, id);
    }

    @Override
    public List<Drink> findByLoaiId(String maDanhMuc) {
        return XQuery.getBeanList(Drink.class, SELECT_DRINK_BY_CATEGORY_SQL, maDanhMuc);
    }
}
