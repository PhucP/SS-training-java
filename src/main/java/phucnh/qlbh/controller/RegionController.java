package phucnh.qlbh.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import phucnh.qlbh.model.dto.CreateRegionDTO;
import phucnh.qlbh.model.dto.UpdateRegionDTO;
import phucnh.qlbh.model.entity.Region;
import phucnh.qlbh.service.BaseService;

@RestController
@RequestMapping("/region")
public class RegionController extends BaseController<Region, Long> {

    public RegionController(BaseService<Region, Long> service) {
        super(service);
    }

    @GetMapping("/all")
    @Override
    public List<Region> findAll() {
        return super.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public Region findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateRegionDTO createRegionDTO) {
        System.out.println(createRegionDTO.getRegionName());
        Region region = Region.builder()
                .regionName(createRegionDTO.getRegionName())
                .build();
        service.add(region);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        super.delete(id);
    }

    @PostMapping("/update/{id}")
    public void updateRegion(@PathVariable Long id, @RequestBody UpdateRegionDTO updateRegionDTO) {
        Region region = Region.builder()
                .regionId(id)
                .regionName(updateRegionDTO.getRegionName())
                .build();
        service.update(id, region);
    }
}
