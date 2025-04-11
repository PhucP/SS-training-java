package phucnh.qlbh.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevenueByEmployeePerMonth {
    private Long employeeId;
    private String fullName;
    private double totalRevenue;
    private String month;
}
