package com.gomezvinuesamario.repository.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(value = "Employee")
public class EmployeeDocument {

    @Id
    private String id;

    private String name;
    private String lastName;
    private String phone;
    private Integer salary;
}
