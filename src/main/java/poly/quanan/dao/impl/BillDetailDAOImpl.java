package poly.quanan.dao.impl;

import poly.quanan.dao.BillDetailDAO;
import poly.quanan.entity.BillDetail;
import poly.quanan.util.XJdbc;
import poly.quanan.util.XQuery;
import java.util.List;

public class BillDetailDAOImpl implements BillDetailDAO {

    private final String createSql = "INSERT INTO BillDetail (MaHD, MaMon, DonGia, SoLuong, GhiChu) VALUES (?, ?, ?, ?, ?)";
    private final String updateSql = "UPDATE BillDetail SET DonGia=?, SoLuong=?, GhiChu=? WHERE MaHD=? AND MaMon=?";
    private final String deleteSql = "DELETE FROM BillDetail WHERE MaCT=?";

    private final String findAllSql = """
        SELECT 
            bd.*, 
            m.TenMon AS TenMon, 
            (bd.SoLuong * bd.DonGia) AS ThanhTien 
        FROM BillDetail bd 
        JOIN MonAn m ON m.MaMon = bd.MaMon
    """;

    private final String findByHoaDonIdSql = findAllSql + " WHERE bd.MaHD=?";
    private final String findByMonIdSql = findAllSql + " WHERE bd.MaMon=?";
    private final String findByIdSql = findAllSql + " WHERE bd.MaHD=? AND bd.MaMon=?";
    private final String findLastSql = findAllSql + " WHERE bd.MaCT IN (SELECT MAX(MaCT) FROM BillDetail)";

    @Override
    public BillDetail create(BillDetail entity) {
        Object[] values = {
            entity.getMaHD(),
            entity.getMaMon(),
            entity.getDonGia(),
            entity.getSoLuong(),
        };
        XJdbc.executeUpdate(createSql, values);
        return XQuery.getSingleBean(BillDetail.class, findLastSql);
    }

    @Override
    public void update(BillDetail entity) {
        Object[] values = {
            entity.getDonGia(),
            entity.getSoLuong(),
            entity.getMaHD(),
            entity.getMaMon()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Long maCT) {
        XJdbc.executeUpdate(deleteSql, maCT);
    }

    public void deleteByHoaDonVaMon(int maHD, int maMon) {
        String sql = "DELETE FROM BillDetail WHERE MaHD=? AND MaMon=?";
        XJdbc.executeUpdate(sql, maHD, maMon);
    }

    @Override
    public List<BillDetail> findAll() {
        return XQuery.getBeanList(BillDetail.class, findAllSql);
    }

    @Override
    public BillDetail findById(Long id) {
        throw new UnsupportedOperationException("BillDetail cần 2 khóa (MaHD, MaMon) để tìm.");
    }

    public BillDetail findById(int maHD, int maMon) {
        return XQuery.getSingleBean(BillDetail.class, findByIdSql, maHD, maMon);
    }

    public List<BillDetail> findByHoaDonId(Long maHD) {
        return XQuery.getBeanList(BillDetail.class, findByHoaDonIdSql, maHD);
    }

    public List<BillDetail> findByMonId(int maMon) {
        return XQuery.getBeanList(BillDetail.class, findByMonIdSql, maMon);
    }

    @Override
    public List<BillDetail> findByBillId(Long billId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BillDetail> findByProductId(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
