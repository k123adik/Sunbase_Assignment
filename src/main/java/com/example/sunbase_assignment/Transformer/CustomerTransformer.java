package com.example.sunbase_assignment.Transformer;
import com.example.sunbase_assignment.dto.requestDto.CustomerRequestDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerFoundResponseDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerResponseDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerUpdateResponseDto;
import com.example.sunbase_assignment.entity.Customer;

public class CustomerTransformer {

    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        //convert dto to entity
        return Customer.builder()
                .firstName(customerRequestDto.getFirstName())
                .lastName(customerRequestDto.getLastName())
                .street(customerRequestDto.getStreet())
                .address(customerRequestDto.getAddress())
                .city(customerRequestDto.getCity())
                .state(customerRequestDto.getState())
                .email(customerRequestDto.getEmail())
                .phone(customerRequestDto.getPhone())
                .build();
    }

    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer){
        //entity to dto
        return CustomerResponseDto.builder()
                .name(customer.getFirstName() + " " + customer.getLastName())
                .message("Customer Added Successfully!")
                .build();
    }

    public static CustomerUpdateResponseDto customerToCustomerUpdateResponseDto(Customer customer){
        //entity to dto
        return CustomerUpdateResponseDto.builder()
                .message("Customer updated successfully!")
                .build();
    }

    public static CustomerFoundResponseDto customerToCustomerFoundResponseDto(Customer customer){
        //entity tio dto
        return CustomerFoundResponseDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .street(customer.getStreet())
                .address(customer.getAddress())
                .state(customer.getState())
                .city(customer.getCity())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }
}
