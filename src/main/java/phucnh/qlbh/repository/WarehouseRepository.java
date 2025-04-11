package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import phucnh.qlbh.model.entity.Warehouse;

@RepositoryRestResource(collectionResourceRel = "warehouse", path = "warehouse")
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
