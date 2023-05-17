package com.gomezvinuesamario.repository.employee;

import com.gomezvinuesamario.domain.Employee;
import com.gomezvinuesamario.repository.client.MongoClientRepository;
import com.gomezvinuesamario.repository.model.EmployeeDocument;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private MongoEmployeeRepository mongoEmployeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return modelMapper.map(mongoEmployeeRepository.insert(modelMapper.map(employee, EmployeeDocument.class)),Employee.class);
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
