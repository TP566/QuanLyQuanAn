/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.quanan.ui;

import gao.entity.HoaDon;

/**
 *
 * @author lengh
 */
public interface HoaDonController {
    void setHoaDon(HoaDon hoadon); // truyền bill vào cửa sổ để hiển thị

    void open(); // Hiển thị bill

    void close(); // Xóa bill nếu ko chứa đồ uống nào

    void showGaoJDialog(); // Hiển thị cửa sổ bổ sung đồ uống vào bill

    void removeGao(); // Xóa đồ uống khỏ

    void updateSoLuong(); // Thay đổi số lượng đồ uống

    void checkout(); // Thanh toán

    void cancel(); // Hủy bill
}
