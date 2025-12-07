package com.learning.prometheus.dto;

import com.learning.prometheus.enums.EmployeeType;
import lombok.Data;

@Data
public class EmployeeRegistrationResponse {
    private String id;
    private String name;
    private EmployeeType employeeType;
}
