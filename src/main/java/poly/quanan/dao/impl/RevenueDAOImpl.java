<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
=======
>>>>>>> 059eae8 (Cập nhật code)
package poly.quanan.impl;

import poly.quanan.entity.Revenue;
import poly.quanan.dao.RevenueDAO;
<<<<<<< HEAD
import poly.quanan.ui.manager.RevenueController;
import poly.quanan.util.XQuery;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author lengh
 */
=======
import poly.quanan.util.XQuery;

import java.sql.Date;
import java.util.List;

>>>>>>> 059eae8 (Cập nhật code)
public class RevenueDAOImpl implements RevenueDAO {

    @Override
    public List<Revenue.ByLoai> getByCategory(Date begin, Date end) {
        String sql = """
<<<<<<< HEAD
        SELECT l.TenLoai AS Tenloai,
               SUM(ct.DonGia * ct.SoLuong * (1 - ct.GiamGia)) AS Revenue,
               SUM(ct.SoLuong) AS Soluong,
               MAX(ct.DonGia) AS Giabancaonhat,
               MIN(ct.DonGia) AS Giabanthapnhat,
               AVG(ct.DonGia) AS Giabantb
        FROM ChiTietHoaDon ct
        JOIN HoaDon hd ON hd.MaHD = ct.MaHD
        JOIN Gao g ON g.MaGao = ct.MaGao
        JOIN LoaiGao l ON l.MaLoai = g.MaLoai
        WHERE hd.TrangThai = 1
          AND hd.ThoiGianRa BETWEEN ? AND ?
        GROUP BY l.TenLoai
        ORDER BY Revenue DESC
    """;
=======
            SELECT 
                c.TenDanhMuc AS Name,
                SUM(bd.DonGia * bd.SoLuong) AS Revenue,
                SUM(bd.SoLuong) AS Quantity,
                MAX(bd.DonGia) AS HighestPrice,
                MIN(bd.DonGia) AS LowestPrice,
                AVG(bd.DonGia) AS AveragePrice
            FROM BillDetail bd
            JOIN Bill b ON b.MaHD = bd.MaHD
            JOIN Drink d ON d.DrinkId = bd.MaMon
            JOIN Category c ON c.MaDanhMuc = d.CategoryId
            WHERE b.Status = 1
              AND b.Checkout BETWEEN ? AND ?
            GROUP BY c.TenDanhMuc
            ORDER BY Revenue DESC
        """;
>>>>>>> 059eae8 (Cập nhật code)

        return XQuery.getBeanList(Revenue.ByLoai.class, sql, begin, end);
    }

    @Override
    public List<Revenue.ByUser> getByUser(Date begin, Date end) {
        String sql = """
<<<<<<< HEAD
        SELECT 
            hd.Username AS Ten,
            SUM(ct.DonGia * ct.SoLuong * (1 - ISNULL(ct.GiamGia, 0))) AS Revenue,
            COUNT(DISTINCT hd.MaHD) AS SoluongHang,
            MIN(hd.ThoiGianVao) AS firstTime,
            MAX(hd.ThoiGianRa) AS lastTime
        FROM ChiTietHoaDon ct
        JOIN HoaDon hd ON hd.MaHD = ct.MaHD
        WHERE hd.TrangThai = 1
          AND hd.ThoiGianRa BETWEEN ? AND ?
        GROUP BY hd.Username
        ORDER BY Revenue DESC
    """;

        return XQuery.getBeanList(Revenue.ByUser.class, sql, begin, end);
    }

=======
            SELECT 
                u.Fullname AS Ten,
                SUM(bd.DonGia * bd.SoLuong) AS Revenue,
                SUM(bd.SoLuong) AS StockQuantity,
                MIN(b.Checkin) AS firstTime,
                MAX(b.Checkout) AS lastTime
            FROM BillDetail bd
            JOIN Bill b ON b.MaHD = bd.MaHD
            JOIN Users u ON u.Username = b.Username
            WHERE b.Status = 1
              AND b.Checkout BETWEEN ? AND ?
            GROUP BY u.Fullname
            ORDER BY Revenue DESC
        """;

        return XQuery.getBeanList(Revenue.ByUser.class, sql, begin, end);
    }
>>>>>>> 059eae8 (Cập nhật code)
}
