package phucnh.qlbh.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCountryDTO {
    @NotNull
    private String countryName;
    
    @NotNull
    private Long regionID;
}
