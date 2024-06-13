package com.example.sunbase_assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "customer")
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String firstName;

    String lastName;

    String street;

    String address;

    String city;

    String state;

    @Column(unique = true, nullable = false)
    String email;

    @Column(unique = true, nullable = false)
    String phone;

}
