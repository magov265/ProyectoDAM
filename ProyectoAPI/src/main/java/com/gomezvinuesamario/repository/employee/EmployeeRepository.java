package com.gomezvinuesamario.repository.employee;

import com.gomezvinuesamario.domain.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee saveEmployee(Employee client);

    Employee getEmployee(String identifier);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee);

    Employee deleteEmployee(String identifier);
}
