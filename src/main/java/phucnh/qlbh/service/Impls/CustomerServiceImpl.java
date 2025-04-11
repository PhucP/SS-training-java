package phucnh.qlbh.service.Impls;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import phucnh.qlbh.exception.exceptions.NotFoundException;
import phucnh.qlbh.model.dto.CreateCustomerDTO;
import phucnh.qlbh.model.dto.UpdateCustomerDTO;
import phucnh.qlbh.model.entity.Customer;
import phucnh.qlbh.repository.CustomerRepository;
import phucnh.qlbh.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(CreateCustomerDTO dto) {
        Customer newCustomer = Customer.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .website(dto.getWebsite())
                .creditLimit(dto.getCreditLimit())
                .build();

        return customerRepository.save(newCustomer);
    }

    @Override
    public Customer update(Long id, UpdateCustomerDTO dto) {
        Customer customer = findById(id).orElse(null);
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setWebsite(dto.getWebsite());
        customer.setCreditLimit(dto.getCreditLimit());
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        Customer customer = findById(id).orElse(null);
        customerRepository.delete(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.orElse(null) == null) {
            throw new NotFoundException(Customer.class.getName() + " is not found with this id");
        }

        return customer;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
