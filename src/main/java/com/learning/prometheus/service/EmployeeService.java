package com.learning.prometheus.service;

import com.learning.prometheus.dto.EmployeeRegistrationRequest;
import com.learning.prometheus.dto.EmployeeRegistrationResponse;
import com.learning.prometheus.entity.Employee;
import com.learning.prometheus.enums.EmployeeType;
import com.learning.prometheus.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeRegistrationResponse addEmployee(EmployeeRegistrationRequest dto) {

        String base = dto.getName()
                .replace("\\s", ".")
                .toLowerCase();

        String workEmail = generateWorkEmail(base);

        if (dto.getJoinDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("Hire Date cannot from the future");
        }

        EmployeeType employeeType = dto.getEmployeeType();

        int countRole = employeeRepository.countByEmployeeType(employeeType);
        int nextNumber = countRole + 1;

        String id = employeeType.getCode() + "-" + nextNumber;

        Employee employee = new Employee();
        employee.setId(id);
        employee.setWorkEmail(workEmail);
        employee.setName(dto.getName());
        employee.setPassword(dto.getPassword());
        employee.setBirthDate(dto.getBirthDate());
        employee.setJoinDate(dto.getJoinDate());
        employee.setEmployeeType(dto.getEmployeeType());

        var saved = employeeRepository.save(employee);

        EmployeeRegistrationResponse response = new EmployeeRegistrationResponse();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setEmployeeType(saved.getEmployeeType());

        return response;
    }

    private String generateWorkEmail(String base) {
        String domain = "@prometheus.co.id";
        String workEmail = base + domain;
        int counter = 1;
        while (employeeRepository.existsByWorkEmail(workEmail)) {
            workEmail = String.format("%s%d%s", base, counter, domain);
            counter++;
        }
        return workEmail;
    }
}
