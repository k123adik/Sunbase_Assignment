package com.example.sunbase_assignment.dto.requestDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerUpdateRequestDto {

    int customerId;

    String id;

    String firstName;

    String lastName;

    String street;

    String address;

    String city;

    String state;

    String email;

    String phone;
}
