package com.gomezvinuesamario.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String name;
    private String lastName;
    private String phone;
    private Integer salary;
}
