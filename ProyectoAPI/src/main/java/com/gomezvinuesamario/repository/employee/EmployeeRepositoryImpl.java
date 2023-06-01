package com.gomezvinuesamario.repository.employee;

import com.gomezvinuesamario.domain.Employee;
import com.gomezvinuesamario.mappers.EmployeeMapper;
import com.gomezvinuesamario.repository.model.EmployeeDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {


    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private MongoEmployeeRepository mongoEmployeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        //Convertimos el cliente en un cliente document con el mapper
        final EmployeeDocument employeeDocument = employeeMapper.employeeToEmployeeDocument(employee);
        //Nos quedamos con el objeto inserado
        final EmployeeDocument employeeDocumentInsertado = mongoEmployeeRepository.insert(employeeDocument);
        //Transformamos y devovlemos el objeto de dominio huesped
        return employeeMapper.employeeDocumentToEmployee(employeeDocumentInsertado);
    }

    @Override
    public Employee getEmployee(String identifier) {
        final EmployeeDocument employeeDocument = mongoEmployeeRepository.findEmployeeDocumentByIdentifierEquals(identifier);
        if (Objects.nonNull(employeeDocument)) {
            return employeeMapper.employeeDocumentToEmployee(employeeDocument);
        } else {
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeMapper.employeeDocumentListToEmployeeList(mongoEmployeeRepository.findAll());
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        deleteEmployee(employee.getIdentifier());
        return employeeMapper.employeeDocumentToEmployee(mongoEmployeeRepository.insert(employeeMapper.employeeToEmployeeDocument(employee)));
    }

    @Override
    public Employee deleteEmployee(String identifier) {

        final EmployeeDocument employeeDocument = mongoEmployeeRepository.deleteEmployeeDocumentByIdentifierEquals(identifier);
        if (Objects.nonNull(employeeDocument)) {
            return employeeMapper.employeeDocumentToEmployee(employeeDocument);
        }
        return null;

    }
}
