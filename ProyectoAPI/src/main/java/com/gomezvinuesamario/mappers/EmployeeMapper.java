package com.gomezvinuesamario.mappers;

import com.gomezvinuesamario.controller.response.RoomResponse;
import com.gomezvinuesamario.domain.Employee;
import com.gomezvinuesamario.domain.Room;
import com.gomezvinuesamario.repository.model.EmployeeDocument;
import com.gomezvinuesamario.repository.model.RoomDocument;

import java.util.List;

public interface EmployeeMapper {
    EmployeeDocument employeeToEmployeeDocument(Employee employee);

    Employee employeeDocumentToEmployee(EmployeeDocument employeeDocument);

    List<Employee> employeeDocumentListToEmployeeList(List<EmployeeDocument> employeeDocuments);

}
