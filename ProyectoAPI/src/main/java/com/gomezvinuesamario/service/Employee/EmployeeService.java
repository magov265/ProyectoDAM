package com.gomezvinuesamario.service.Employee;

import com.gomezvinuesamario.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployee(String identifier);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee employee);

    Employee deleteEmployee(String identifier);

}
