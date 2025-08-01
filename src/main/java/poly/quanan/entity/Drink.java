package poly.quanan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Drink {
    /** Khóa chính (sinh tự động bởi XStr.getKey()) */
    private String DrinkId;

    /** Tên đồ uống */
    private String DrinkName;

    /** Nguồn gốc / hình ảnh */
    private String Origin;

    /** Giá bán */
    private double price;

    /** Đơn vị tính */
    private String Unit;

    /** Số lượng tồn kho */
    private int StockQuantity;

    /** Mã loại (FK) */
    private String CategoryId;

    /** Phần trăm giảm giá (0–1 hoặc 0–100 tuỳ cách lưu) */
    private double Discount;
}
