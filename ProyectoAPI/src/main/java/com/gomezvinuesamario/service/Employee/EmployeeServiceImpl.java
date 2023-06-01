package com.gomezvinuesamario.service.Employee;


import com.gomezvinuesamario.domain.Employee;
import com.gomezvinuesamario.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }

    @Override
    public Employee getEmployee(String identifier) {
        return employeeRepository.getEmployee(identifier);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee employeeToDelete = employeeRepository.getEmployee(employee.getIdentifier());
        if (Objects.nonNull(employeeToDelete)) {
            return employeeRepository.updateEmployee(employee);
        }
        throw new RuntimeException();
    }

    @Override
    public Employee deleteEmployee(String identifier) {
        return employeeRepository.deleteEmployee(identifier);
    }
}
