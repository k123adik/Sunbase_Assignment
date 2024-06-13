package com.example.sunbase_assignment.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

    private String username;
    private String password;
}
