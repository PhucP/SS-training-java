package phucnh.qlbh.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopCustomer {
    private Long customerId;
    private String name;
    private String address;
    private Long creditLimit;
    private Double totalRevenue;
}
