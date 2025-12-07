package com.learning.prometheus.controller;

import com.learning.prometheus.dto.EmployeeRegistrationRequest;
import com.learning.prometheus.dto.EmployeeRegistrationResponse;
import com.learning.prometheus.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<EmployeeRegistrationResponse> registerEmployee(@Valid @RequestBody EmployeeRegistrationRequest dto) {
        return ResponseEntity.ok(employeeService.addEmployee(dto));
    }
}
