package com.gomezvinuesamario.mappers;

import com.gomezvinuesamario.domain.Employee;
import com.gomezvinuesamario.repository.model.EmployeeDocument;
import com.gomezvinuesamario.repository.model.RoomDocument;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDocument employeeToEmployeeDocument(Employee employee) {
        return EmployeeDocument.builder()
                .identifier(employee.getIdentifier())
                .name(employee.getName())
                .lastName(employee.getLastName())
                .phone(employee.getPhone())
                .salary(employee.getSalary())
                .build();
    }

    @Override
    public Employee employeeDocumentToEmployee(EmployeeDocument employeeDocument) {
        return Employee.builder()
                .identifier(employeeDocument.getIdentifier())
                .name(employeeDocument.getName())
                .lastName(employeeDocument.getLastName())
                .phone(employeeDocument.getPhone())
                .salary(employeeDocument.getSalary())
                .build();
    }

    @Override
    public List<Employee> employeeDocumentListToEmployeeList(List<EmployeeDocument> employeeDocuments) {
        List<Employee> employeeList = new ArrayList<>();

        for (EmployeeDocument employeeDocument : employeeDocuments) {
            employeeList.add(employeeDocumentToEmployee(employeeDocument));
        }

        return employeeList;
    }
}
