package phucnh.qlbh.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CreateEmployeeDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @DateTimeFormat
    private String hireDate;
    
    private String jobTitle;
    private Long managerId;
}
