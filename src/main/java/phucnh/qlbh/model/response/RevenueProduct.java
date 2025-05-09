package phucnh.qlbh.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RevenueProduct {
    private Long productId;
    private String productName;
    private Double totalRevenue;
    private Long instock;
}
