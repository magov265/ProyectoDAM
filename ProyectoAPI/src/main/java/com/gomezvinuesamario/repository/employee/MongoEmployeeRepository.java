package com.gomezvinuesamario.repository.employee;

import com.gomezvinuesamario.repository.model.EmployeeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoEmployeeRepository extends MongoRepository<EmployeeDocument, String> {
    EmployeeDocument findEmployeeDocumentByIdentifierEquals(String identifier);

    EmployeeDocument deleteEmployeeDocumentByIdentifierEquals(String identifier);
}
