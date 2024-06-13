package com.example.sunbase_assignment.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtResponse {
    private String username;
    private String jwtToken;
}
