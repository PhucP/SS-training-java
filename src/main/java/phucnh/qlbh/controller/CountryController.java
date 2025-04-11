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

import phucnh.qlbh.model.dto.CreateCountryDTO;
import phucnh.qlbh.model.dto.UpdateCountryDTO;
import phucnh.qlbh.model.entity.Country;
import phucnh.qlbh.service.CountryService;

@RestController
@RequestMapping("country")
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService CountryService) {
        this.countryService = CountryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Country>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Country>> findById(@PathVariable String id) {
        return ResponseEntity.ok(countryService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Country> add(@RequestBody CreateCountryDTO createCountryDTO) {
        return ResponseEntity.ok(countryService.create(createCountryDTO));
    }   

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        countryService.delete(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable String id, @RequestBody UpdateCountryDTO updateCountryDTO) { 
        return ResponseEntity.ok(countryService.update(id, updateCountryDTO));
    }
}
