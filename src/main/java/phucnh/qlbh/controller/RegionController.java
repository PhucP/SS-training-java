package phucnh.qlbh.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
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
import phucnh.qlbh.service.RegionService;

@RestController
@RequestMapping("/region")
public class RegionController {
    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Region>> findAll() {
        return ResponseEntity.ok(regionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Region>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(regionService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Region> add(@RequestBody CreateRegionDTO createRegionDTO) {
        return ResponseEntity.ok(regionService.create(createRegionDTO));
    }   

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        regionService.delete(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable Long id, @RequestBody UpdateRegionDTO updateRegionDTO) { 
        return ResponseEntity.ok(regionService.update(id, updateRegionDTO));
    }
}
