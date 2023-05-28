package com.gomezvinuesamario.controller;

import com.gomezvinuesamario.domain.Employee;
import com.gomezvinuesamario.service.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("gestionEmployee")
public class HotelGestionEmployeeControllerImpl implements HotelGestionEmployeeController{

    @Autowired
    private EmployeeService employeeService;
    @Override
    @PostMapping("/saveEmployee")
    public ResponseEntity<Employee> saveEmployee(Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @Override
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @Override
    @GetMapping("/getEmployee")
    public ResponseEntity getEmployeeByIdentifier(String identifier) {
        Employee employee = employeeService.getEmployee(identifier);
        if (Objects.isNull(employee)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The client with the cardID: " + identifier + " not found, please check if you put your card ID");
        }
        return ResponseEntity.ok(employee);
    }

    @Override
    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<Employee> deleteEmployee(String identifier) {
        return ResponseEntity.ok(employeeService.deleteEmployee(identifier));
    }

    @Override
    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }
}
