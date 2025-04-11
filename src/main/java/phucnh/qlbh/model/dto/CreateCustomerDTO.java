package phucnh.qlbh.model.dto;

import lombok.Data;

@Data
public class CreateCustomerDTO {
    private String name;
    private String address;
    private String website;
    private Double creditLimit;
}
