package com.example.sunbase_assignment.dto.responseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerFoundResponseDto {

    String firstName;

    String lastName;

    String street;

    String address;

    String city;

    String state;

    String email;

    String phone;
}
