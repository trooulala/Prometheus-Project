package com.learning.prometheus.repository;

import com.learning.prometheus.entity.Employee;
import com.learning.prometheus.enums.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    int countByEmployeeType(EmployeeType employeeType);

    boolean existsByWorkEmail(String workEmail);
}
