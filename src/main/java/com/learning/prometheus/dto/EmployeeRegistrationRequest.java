package com.learning.prometheus.dto;

import com.learning.prometheus.enums.EmployeeType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeRegistrationRequest {
    @NotNull
    private final String name;
    @NotNull
    @Size(min = 3)
    private final String password;
    @Past
    private final LocalDate birthDate;
    @PastOrPresent
    private final LocalDate joinDate;
    @NotNull
    private final EmployeeType employeeType;
}
