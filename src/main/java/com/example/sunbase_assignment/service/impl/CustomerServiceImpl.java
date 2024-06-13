package com.example.sunbase_assignment.service.impl;

import com.example.sunbase_assignment.Transformer.CustomerTransformer;
import com.example.sunbase_assignment.dto.requestDto.CustomerRequestDto;
import com.example.sunbase_assignment.dto.requestDto.CustomerUpdateRequestDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerFoundResponseDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerResponseDto;
import com.example.sunbase_assignment.dto.responseDto.CustomerUpdateResponseDto;
import com.example.sunbase_assignment.entity.Customer;
import com.example.sunbase_assignment.exception.CustomerNotFoundException;
import com.example.sunbase_assignment.repository.CustomerRepository;
import com.example.sunbase_assignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {

        //convert request dto entity
        Customer customer = CustomerTransformer.customerRequestDtoToCustomer(customerRequestDto);

        //save entity to database
        Customer savedCustomer = customerRepository.save(customer);

        //convert entity to response dto
        CustomerResponseDto customerResponseDto = CustomerTransformer.customerToCustomerResponseDto(savedCustomer);

        return customerResponseDto;

    }

    @Override
    public CustomerUpdateResponseDto updateCustomer(CustomerUpdateRequestDto customerUpdateRequestDto) throws CustomerNotFoundException {

        //get customer from id
        int customerId = customerUpdateRequestDto.getCustomerId();
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(!optionalCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer does not exist!");
        }

        Customer customer = optionalCustomer.get();

        customer.setFirstName(customerUpdateRequestDto.getFirstName());
        customer.setLastName(customerUpdateRequestDto.getLastName());
        customer.setStreet(customerUpdateRequestDto.getStreet());
        customer.setAddress(customerUpdateRequestDto.getAddress());
        customer.setCity(customerUpdateRequestDto.getCity());
        customer.setState(customerUpdateRequestDto.getState());
        customer.setEmail(customerUpdateRequestDto.getEmail());
        customer.setPhone(customerUpdateRequestDto.getPhone());

        customerRepository.save(customer);

        //convert entity to response dto
        CustomerUpdateResponseDto customerUpdateResponseDto = CustomerTransformer.customerToCustomerUpdateResponseDto(customer);

        return customerUpdateResponseDto;
    }

    @Override
    public Page<Customer> getCustomersWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Customer> customers = customerRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return customers;
    }

    @Override
    public CustomerFoundResponseDto getCustomerById(int customerId) throws CustomerNotFoundException {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(!optionalCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer does not exist!");
        }

        Customer customer = optionalCustomer.get();

        //convert entity to response dto
        CustomerFoundResponseDto customerFoundResponseDto = CustomerTransformer.customerToCustomerFoundResponseDto(customer);

        return customerFoundResponseDto;
    }

    @Override
    public String deleteCustomer(int customerId) throws CustomerNotFoundException {

        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(!optionalCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer does not exist!");
        }

        Customer customer = optionalCustomer.get();
        customerRepository.delete(customer);
        return "Customer Deleted Successfully!";
    }
}
