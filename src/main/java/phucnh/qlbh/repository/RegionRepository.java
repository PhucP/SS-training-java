package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import phucnh.qlbh.model.entity.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
     
}
