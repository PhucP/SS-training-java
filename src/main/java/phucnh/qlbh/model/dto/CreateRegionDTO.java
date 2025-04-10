package phucnh.qlbh.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateRegionDTO {
    @NotNull
    private String regionName;
}
