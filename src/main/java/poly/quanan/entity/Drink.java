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
    private int DrinkId;
    private String DrinkName;
    private String Origin;
    private double Price;
    private String Unit;
    private int StockQuantity;
    private String CategoryId;
    private double Discount;
}

