/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.quanan.entity;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author lengh
 */
public class Revenue {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class ByLoai {

        private String Name; // Tên loại
        private double Revenue; // Doanh thu
        private int Quantity; // Số lượng đồ uống đã bán
        private double HighestPrice; // Giá bán cao nhất
        private double LowestPrice; // Giá bán thấp nhất
        private double AveragePrice; // Giá bán trung bình
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class ByUser {

        private String Ten;
        private double Revenue;
        private int StockQuantity;
        private Timestamp firstTime; // sửa lại
        private Timestamp lastTime;  // sửa lại
    }

}
