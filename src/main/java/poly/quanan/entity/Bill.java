package poly.quanan.entity;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Bill {

    private Integer cardId;
    private Integer maHd;
    private String username;
    private Timestamp Checkin;
    private Timestamp Checkout;
    private Integer Status;

    public static final String DATE_PATTERN = "HH:mm:ss dd-MM-yyyy";
}
