/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package poly.quanan.ui.manager;

import poly.quanan.entity.Bill;

/**
 *
 * @author lengh
 */
public interface BillController {
    void setHoaDon(Bill hoadon); // truyền bill vào cửa sổ để hiển thị

    void open(); // Hiển thị bill

    void close(); // Xóa bill nếu ko chứa đồ uống nào

    void showBillJDialog(); // Hiển thị cửa sổ bổ sung đồ uống vào bill

    void removeBill(); // Xóa đồ uống khỏ

    void updateSoLuong(); // Thay đổi số lượng đồ uống

    void checkout(); // Thanh toán

    void cancel(); // Hủy bill
}
