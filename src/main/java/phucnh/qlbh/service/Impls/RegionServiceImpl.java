package phucnh.qlbh.service.Impls;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import phucnh.qlbh.exception.exceptions.NotFoundException;
import phucnh.qlbh.model.dto.CreateRegionDTO;
import phucnh.qlbh.model.dto.UpdateRegionDTO;
import phucnh.qlbh.model.entity.Region;
import phucnh.qlbh.repository.RegionRepository;
import phucnh.qlbh.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;
    
    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public Region create(CreateRegionDTO dto) {
        Region newRegion = Region.builder()
                .regionName(dto.getRegionName())
                .build();

        return regionRepository.save(newRegion);
    }

    @Override
    public Region update(Long id, UpdateRegionDTO dto) {
        Region region = findById(id).orElse(null);
        region.setRegionName(dto.getRegionName());
        return regionRepository.save(region);
    }

    @Override
    public void delete(Long id) {
        Region region = findById(id).orElse(null);
        regionRepository.delete(region);
    }

    @Override
    public Optional<Region> findById(Long id) {
        Optional<Region> region = regionRepository.findById(id);
        if(region.orElse(null) == null) {
            throw new NotFoundException(Region.class.getName() + " is not found with this id");
        }

        return region;
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

}
