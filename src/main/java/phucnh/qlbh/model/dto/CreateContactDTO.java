package phucnh.qlbh.model.dto;

import lombok.Data;

@Data
public class CreateContactDTO {    
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String phone;
    
    private Long customerId;
}
