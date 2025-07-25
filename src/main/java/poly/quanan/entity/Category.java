package poly.quanan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Category {

    private String maLoai;    // Mã loại đồ uống (ví dụ: DR01)
    private String tenLoai;   // Tên loại đồ uống (ví dụ: Cà phê, Nước ép...)
}
