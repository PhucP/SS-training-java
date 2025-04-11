package phucnh.qlbh.service;

import java.util.List;
import java.util.Optional;

import phucnh.qlbh.model.dto.CreateRegionDTO;
import phucnh.qlbh.model.dto.UpdateRegionDTO;
import phucnh.qlbh.model.entity.Region;

public interface RegionService {
    Region create(CreateRegionDTO dto);
    Region update(Long id, UpdateRegionDTO dto);
    void delete(Long id);
    Optional<Region> findById(Long id);
    List<Region> findAll();
}
