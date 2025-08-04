/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.quanan.dao.impl;

import java.util.List;
import poly.quanan.dao.NhaCungCapDAO;
import poly.quanan.entity.NhaCungCap;
import poly.quanan.util.XJdbc;
import poly.quanan.util.XQuery;

/**
 *
 * @author admin
 */
public class NhaCungCapDAOImpl implements NhaCungCapDAO {

    private static final String INSERT_SQL
            = "INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChi, SoDT, Email) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL
            = "UPDATE NhaCungCap SET TenNCC=?, DiaChi=?, SoDT=?, Email=? WHERE MaNCC=?";
    private static final String DELETE_SQL
            = "DELETE FROM NhaCungCap WHERE MaNCC=?";
    private static final String SELECT_ALL_SQL
            = "SELECT * FROM NhaCungCap";
    private static final String SELECT_BY_ID
            = "SELECT * FROM NhaCungCap WHERE MaNCC=?";

    @Override
    public NhaCungCap create(NhaCungCap entity) {
        Object[] args = {
            entity.getMaNCC(),
            entity.getTenNCC(),
            entity.getDiaChi(),
            entity.getSoDT(),
            entity.getEmail()
        };
        XJdbc.executeUpdate(INSERT_SQL, args);
        return entity;
    }

    @Override
    public void update(NhaCungCap entity) {
        Object[] args = {
            entity.getTenNCC(),
            entity.getDiaChi(),
            entity.getSoDT(),
            entity.getEmail(),
            entity.getMaNCC()
        };
        XJdbc.executeUpdate(UPDATE_SQL, args);
    }

    @Override
    public void deleteById(Integer id) {
        XJdbc.executeUpdate(DELETE_SQL, id);
    }

    @Override
    public List<NhaCungCap> findAll() {
        return XQuery.getBeanList(NhaCungCap.class, SELECT_ALL_SQL);
    }

    @Override
    public NhaCungCap findById(Integer id) {
        return XQuery.getSingleBean(NhaCungCap.class, SELECT_BY_ID, id);
    }
}
