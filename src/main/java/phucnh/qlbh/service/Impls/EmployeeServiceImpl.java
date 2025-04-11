package phucnh.qlbh.service.Impls;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import phucnh.qlbh.exception.exceptions.NotFoundException;
import phucnh.qlbh.exception.exceptions.ParseDateException;
import phucnh.qlbh.model.dto.CreateEmployeeDTO;
import phucnh.qlbh.model.dto.UpdateEmployeeDTO;
import phucnh.qlbh.model.entity.Employee;
import phucnh.qlbh.repository.EmployeeRepository;
import phucnh.qlbh.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(CreateEmployeeDTO dto) {
        Employee manager = null;
        if(dto.getManagerId() != null) {
            manager = findById(dto.getManagerId()).orElse(null);
            if(manager == null) {
                throw new NotFoundException("can't create employee because of manager not found");
            }
        }

        Employee newEmployee = Employee.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .hireDate(convertStringToDate(dto.getHireDate()))
                .jobTitle(dto.getJobTitle())
                .build();

        return employeeRepository.save(newEmployee);
    }

    private Date convertStringToDate(String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
            return formatter.parse(date);
        } catch(ParseDateException e) {
            throw new ParseDateException("wrong date format");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Employee update(Long id, UpdateEmployeeDTO dto) {
        Employee manager = null;
        if(dto.getManagerId() != null) {
            manager = findById(dto.getManagerId()).orElse(null);
            if(manager == null) {
                throw new NotFoundException("can't create employee because of manager not found");
            }
        }

        Employee employee = findById(id).orElse(null);
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setHireDate(convertStringToDate(dto.getHireDate()));
        employee.setJobTitle(dto.getJobTitle());
        employee.setManager(manager);
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        Employee employee = findById(id).orElse(null);
        employeeRepository.delete(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.orElse(null) == null) {
            throw new NotFoundException(Employee.class.getName() + " is not found with this id");
        }

        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
