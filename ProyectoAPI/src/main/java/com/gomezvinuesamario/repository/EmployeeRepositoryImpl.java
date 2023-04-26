package com.gomezvinuesamario.repository;

import com.gomezvinuesamario.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    // Falta implementar el @Mapper
    private MongoClientRepository mongoClientRepository;


    @Override
    public Employee saveEmployee(Employee client) {
        return null;
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee client) {
        return null;
    }

    @Override
    public Employee deleteEmployee(Employee client) {
        return null;
    }
}
