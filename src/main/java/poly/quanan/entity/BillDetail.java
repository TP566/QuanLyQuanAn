package poly.quanan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BillDetail {
    private int maCT;
    private int maHD;        // Mã hóa đơn - khóa ngoại tới HoaDon
    private int maMon;       // Mã món ăn - khóa ngoại tới Mon
    private double donGia;   // Đơn giá
    private double giamGia;  // Giảm giá (có thể theo phần trăm hoặc giá trị)
    private int soLuong;     // Số lượng
    private double thanhTien;// Thành tiền = (đơn giá - giảm giá) * số lượng
    private String tenMon;   // Tên món ăn
}
