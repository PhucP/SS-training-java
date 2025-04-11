package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phucnh.qlbh.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
