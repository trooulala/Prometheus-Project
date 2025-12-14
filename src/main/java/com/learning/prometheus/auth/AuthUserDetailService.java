package com.learning.prometheus.auth;

import com.learning.prometheus.entity.Employee;
import com.learning.prometheus.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserDetailService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String workEmail) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByWorkEmail(workEmail)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return new AuthUserDetails(employee);
    }
}
