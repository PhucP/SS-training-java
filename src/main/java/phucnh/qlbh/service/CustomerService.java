package phucnh.qlbh.service;

import java.util.List;
import java.util.Optional;

import phucnh.qlbh.model.dto.CreateCustomerDTO;
import phucnh.qlbh.model.dto.UpdateCustomerDTO;
import phucnh.qlbh.model.entity.Customer;

public interface CustomerService {
    Customer create(CreateCustomerDTO dto);
    Customer update(Long id, UpdateCustomerDTO dto);
    void delete(Long id);
    Optional<Customer> findById(Long id);
    List<Customer> findAll();
}
