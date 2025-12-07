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

    @Column(unique = true)
    private String workEmail;

    private String name;

    private String password;

    private LocalDate birthDate;

    private LocalDate joinDate;

    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    @OneToMany(mappedBy = "employee")
    private List<Transaction> transactions;
}
