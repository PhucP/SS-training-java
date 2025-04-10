package phucnh.qlbh.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "countries")
public class Country {
    
    @Id
    @Column(name = "country_id", length = 2)
    private String countryId;
    
    @Column(name = "country_name", nullable = false)
    private String countryName;
    
    @ManyToOne
    @JoinColumn(name = "region_id", nullable = true)
    private Region region;
}
