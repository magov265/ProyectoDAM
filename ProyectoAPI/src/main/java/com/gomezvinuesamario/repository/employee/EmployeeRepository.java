package com.gomezvinuesamario.repository.employee;

import com.gomezvinuesamario.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository {
    Employee saveEmployee(Employee client);

    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee client);

    Employee deleteEmployee(Employee client);
}
