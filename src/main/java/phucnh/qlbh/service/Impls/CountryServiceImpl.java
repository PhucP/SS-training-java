package phucnh.qlbh.service.Impls;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import phucnh.qlbh.model.entity.Country;
import phucnh.qlbh.service.CountryService;

@Service
public class CountryServiceImpl extends BaseServiceImpl<Country, String> implements CountryService {

    public CountryServiceImpl(JpaRepository<Country, String> repository, Country country) {
        super(repository, new Country());
    }
}
