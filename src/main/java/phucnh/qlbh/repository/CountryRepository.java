package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import phucnh.qlbh.model.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

}
