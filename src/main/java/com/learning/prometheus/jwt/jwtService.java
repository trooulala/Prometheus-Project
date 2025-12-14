package com.learning.prometheus.jwt;

import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class jwtService {
    @Value("${app.jwt.secret}")
    private String secretKey;
}
