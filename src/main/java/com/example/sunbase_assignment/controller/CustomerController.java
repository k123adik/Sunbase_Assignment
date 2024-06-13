package com.example.sunbase_assignment.controller;

import com.example.sunbase_assignment.dto.requestDto.CustomerRequestDto;
import com.example.sunbase_assignment.dto.requestDto.CustomerUpdateRequestDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerFoundResponseDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerResponseDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerUpdateResponseDto;
import com.example.sunbase_assignment.entity.Customer;
import com.example.sunbase_assignment.exception.CustomerNotFoundException;
import com.example.sunbase_assignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity createCustomer(@RequestBody CustomerRequestDto customerRequestDto){

        CustomerResponseDto customerResponseDto = customerService.createCustomer(customerRequestDto);
        return new ResponseEntity<>(customerResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity updateCustomer(@RequestBody CustomerUpdateRequestDto customerUpdateRequestDto) throws CustomerNotFoundException {

        try {
            CustomerUpdateResponseDto customerUpdateResponseDto = customerService.updateCustomer(customerUpdateRequestDto);
            return new ResponseEntity<>(customerUpdateResponseDto, HttpStatus.OK);
        }
        catch(CustomerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_with_pagination_and_sorting")
    public ResponseEntity getCustomersWithPaginationAndSorting(@RequestParam int offset, @RequestParam int pageSize, @RequestParam String field){

        Page<Customer> customers = customerService.getCustomersWithPaginationAndSorting(offset, pageSize, field);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/get_by_id")
    public ResponseEntity getCustomerById(@RequestParam int customerId) throws CustomerNotFoundException {

        try{
            CustomerFoundResponseDto customerFoundResponseDto = customerService.getCustomerById(customerId);
            return new ResponseEntity<>(customerFoundResponseDto, HttpStatus.FOUND);
        }
        catch(CustomerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteCustomer(@RequestParam int customerId) throws CustomerNotFoundException {

        try {
            String message = customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
        catch(CustomerNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
