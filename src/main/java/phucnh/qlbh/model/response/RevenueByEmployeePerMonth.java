package phucnh.qlbh.model.response;

import lombok.Data;

@Data
public class RevenueByEmployeePerMonth {
    private Long employeeId;
    private String fullName;
    private double totalRevenue;
    private String month;
}
