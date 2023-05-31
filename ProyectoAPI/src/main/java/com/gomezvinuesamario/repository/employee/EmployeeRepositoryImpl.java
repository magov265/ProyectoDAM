package com.gomezvinuesamario.repository.employee;

import com.gomezvinuesamario.domain.Employee;
import com.gomezvinuesamario.repository.model.EmployeeDocument;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private MongoEmployeeRepository mongoEmployeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return modelMapper.map(mongoEmployeeRepository.insert(modelMapper.map(employee, EmployeeDocument.class)), Employee.class);
    }

    @Override
    public Employee getEmployee(String identifier) {
        EmployeeDocument employeeDocument = mongoEmployeeRepository.findEmployeeDocumentByIdentifierEquals(identifier);
        if (Objects.nonNull(employeeDocument)) {
            return modelMapper.map(employeeDocument, Employee.class);
        } else {
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeesDomain = new ArrayList<>();
        for (EmployeeDocument employeeDocument : mongoEmployeeRepository.findAll()) {
            employeesDomain.add(modelMapper.map(employeeDocument, Employee.class));
        }
        return employeesDomain;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        deleteEmployee(employee.getIdentifier());
        return modelMapper.map(mongoEmployeeRepository.insert(modelMapper.map(employee, EmployeeDocument.class)), Employee.class);
    }

    @Override
    public Employee deleteEmployee(String identifier) {

        EmployeeDocument employeeDocument = mongoEmployeeRepository.deleteEmployeeDocumentByIdentifierEquals(identifier);

        if (Objects.nonNull(employeeDocument)) {
            return modelMapper.map(employeeDocument, Employee.class);
        }
        return null;

    }
}
