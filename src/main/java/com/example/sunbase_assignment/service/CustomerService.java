package com.example.sunbase_assignment.service;

import com.example.sunbase_assignment.dto.requestDto.CustomerRequestDto;
import com.example.sunbase_assignment.dto.requestDto.CustomerUpdateRequestDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerFoundResponseDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerResponseDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerUpdateResponseDto;
import com.example.sunbase_assignment.entity.Customer;
import com.example.sunbase_assignment.exception.CustomerNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {

    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);

    public CustomerUpdateResponseDto updateCustomer(CustomerUpdateRequestDto customerUpdateRequestDto) throws CustomerNotFoundException;

    public Page<Customer> getCustomersWithPaginationAndSorting(int offset, int pageSize, String field);

    public CustomerFoundResponseDto getCustomerById(int customerId) throws CustomerNotFoundException;

    public String deleteCustomer(int customerId) throws CustomerNotFoundException;

}
