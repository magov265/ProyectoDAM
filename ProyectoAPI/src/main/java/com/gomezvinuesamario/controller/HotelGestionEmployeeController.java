package com.gomezvinuesamario.controller;

import com.gomezvinuesamario.domain.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface HotelGestionEmployeeController {

    ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee);

    ResponseEntity<List<Employee>> getAllEmployees();

    ResponseEntity <Employee> getEmployeeByIdentifier(@RequestParam String identifier);

    ResponseEntity <Employee> deleteEmployee(@RequestParam String identifier);

    ResponseEntity <Employee> updateEmployee(@RequestBody Employee employee);
}
