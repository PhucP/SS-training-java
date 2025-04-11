package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import phucnh.qlbh.model.entity.OrderItem;
import phucnh.qlbh.model.entity.OrderItemPK;

@RepositoryRestResource(collectionResourceRel = "orderItem", path = "orderItem")
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
