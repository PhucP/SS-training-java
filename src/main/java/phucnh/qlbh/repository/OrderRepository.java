package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import phucnh.qlbh.model.entity.Order;

@RepositoryRestResource(collectionResourceRel = "order", path = "order")
public interface OrderRepository extends JpaRepository<Order, Long> {

}
