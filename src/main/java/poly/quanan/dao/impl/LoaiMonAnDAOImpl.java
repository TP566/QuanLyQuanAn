package poly.quanan.dao.impl;

import java.util.List;
import poly.quanan.dao.LoaiMonAnDAO;
import poly.quanan.entity.Drink;
import poly.quanan.entity.LoaiMonAn;
import poly.quanan.util.XJdbc;
import poly.quanan.util.XQuery;

public class LoaiMonAnDAOImpl implements LoaiMonAnDAO {

    private final String createSql = "INSERT INTO POLY_QUAN_AN_Category(Id, Name) VALUES(?, ?)";
    private final String updateSql = "UPDATE POLY_QUAN_AN_Category SET Name=? WHERE Id=?";
    private final String deleteByIdSql = "DELETE FROM POLY_QUAN_AN_Category WHERE Id=?";
    private final String findAllSql = "SELECT * FROM POLY_QUAN_AN_Category";
    private final String findByIdSql = "SELECT * FROM POLY_QUAN_AN_Category WHERE Id=?";

    public LoaiMonAn create(LoaiMonAn entity) {
        Object[] values = {
            entity.getMaDanhMuc(),
            entity.getTenDanhMuc()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    public void update(LoaiMonAn entity) {
        Object[] values = {
            entity.getTenDanhMuc(),
            entity.getMaDanhMuc()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(String id) {
        XJdbc.executeUpdate(deleteByIdSql, id);
    }

    @Override
    public List<LoaiMonAn> findAll() {
        return XQuery.getBeanList(LoaiMonAn.class, findAllSql);
    }

    @Override
    public LoaiMonAn findById(String id) {
        return XQuery.getSingleBean(LoaiMonAn.class, findByIdSql, id);
    }

    @Override
    public List<Drink> findByLoaiId(String maLoai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
