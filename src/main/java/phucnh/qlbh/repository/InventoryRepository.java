package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import phucnh.qlbh.model.entity.Inventory;
import phucnh.qlbh.model.entity.InventoryPK;

@RepositoryRestResource(collectionResourceRel = "inventory", path = "inventory")
public interface InventoryRepository extends JpaRepository<Inventory, InventoryPK> {

}
