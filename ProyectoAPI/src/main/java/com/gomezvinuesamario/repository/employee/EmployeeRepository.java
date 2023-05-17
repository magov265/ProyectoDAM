package com.gomezvinuesamario.repository.employee;

import com.gomezvinuesamario.domain.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository {
    Employee saveEmployee(Employee client);

    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee client);

    Employee deleteEmployee(Employee client);
}
