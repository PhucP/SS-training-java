package phucnh.qlbh.service.Impls;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import phucnh.qlbh.exception.exceptions.NotFoundException;
import phucnh.qlbh.model.dto.CreateCountryDTO;
import phucnh.qlbh.model.dto.UpdateCountryDTO;
import phucnh.qlbh.model.entity.Country;
import phucnh.qlbh.model.entity.Region;
import phucnh.qlbh.repository.CountryRepository;
import phucnh.qlbh.service.CountryService;
import phucnh.qlbh.service.RegionService;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final RegionService regionService;
    
    public CountryServiceImpl(CountryRepository countryRepository, RegionService regionService) {
        this.countryRepository = countryRepository;
        this.regionService = regionService;
    }

    @Override
    public Country create(CreateCountryDTO dto) {
        Region region = regionService.findById(dto.getRegionID()).orElse(null);
        Country newCountry = Country.builder()
                .region(region)
                .countryName(dto.getCountryName())
                .build();

        return countryRepository.save(newCountry);
    }

    @Override
    public Country update(String id, UpdateCountryDTO dto) {
        Country Country = findById(id).orElse(null);
        Country.setCountryName(dto.getCountryName());
        return countryRepository.save(Country);
    }

    @Override
    public void delete(String id) {
        Country Country = findById(id).orElse(null);
        countryRepository.delete(Country);
    }

    @Override
    public Optional<Country> findById(String id) {
        Optional<Country> Country = countryRepository.findById(id);
        if(Country.orElse(null) == null) {
            throw new NotFoundException(Country.class.getName() + " is not found with this id");
        }

        return Country;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

}
