package com.gomezvinuesamario.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(value = "Employee")
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDocument {

    @Id
    private String id;

    private String name;
    private String lastName;
    private String phone;
    private Integer salary;
}
