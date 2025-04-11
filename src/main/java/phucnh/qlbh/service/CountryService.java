package phucnh.qlbh.service;

import java.util.List;
import java.util.Optional;

import phucnh.qlbh.model.dto.CreateCountryDTO;
import phucnh.qlbh.model.dto.UpdateCountryDTO;
import phucnh.qlbh.model.entity.Country;

public interface CountryService {
    Country create(CreateCountryDTO dto);
    Country update(String id, UpdateCountryDTO dto);
    void delete(String id);
    Optional<Country> findById(String id);
    List<Country> findAll();
}
