package phucnh.qlbh.service;

import java.util.List;
import java.util.Optional;

import phucnh.qlbh.model.dto.CreateEmployeeDTO;
import phucnh.qlbh.model.dto.UpdateEmployeeDTO;
import phucnh.qlbh.model.entity.Employee;

public interface EmployeeService {
    Employee create(CreateEmployeeDTO dto);
    Employee update(Long id, UpdateEmployeeDTO dto);
    void delete(Long id);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
}
