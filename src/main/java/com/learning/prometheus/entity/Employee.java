package com.learning.prometheus.entity;

import com.learning.prometheus.enums.EmployeeType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employees")
public class Employee {
    @Id
    private String id;

    private String name;

    private LocalDate birthDate;

    private LocalDate joinDate;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @OneToMany(mappedBy = "employee")
    private List<Transaction> transactions;
}
