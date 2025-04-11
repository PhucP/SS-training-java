package phucnh.qlbh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import phucnh.qlbh.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
