package phucnh.qlbh.model.entity;

import java.util.Comparator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "regions")
public class Region implements Comparator<Region> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regionId;
    
    @Column(name = "region_name", nullable = false)
    private String regionName;

    @Override
    public int compare(Region region1, Region region2) {
        if(region1.getRegionName() == region2.getRegionName()) return 0;
        else return 1;
    }
}
