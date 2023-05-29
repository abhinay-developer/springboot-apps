package com.abhi.modelmapper.controller;


import com.abhi.modelmapper.dto.CustomerDto;
import com.abhi.modelmapper.dto.CustomerResponse;
import com.abhi.modelmapper.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto saveCustomer = customerService.saveCustomer(customerDto);
        return new ResponseEntity<>(saveCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomerById(@RequestBody CustomerDto customerDto, @PathVariable Long id) {
        CustomerDto updateCustomer = customerService.updateCustomer(customerDto, id);
        return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
        CustomerResponse customerResponse = customerService.findCustomerById(id);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> customerResponseList = customerService.findAllCustomers();
        return new ResponseEntity<>(customerResponseList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Long>> deleteCustomerById(@PathVariable Long id) {
        Map<String, Long> hashMap = new HashMap<>();
        hashMap.put("Deleted Successfully", id);
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }
}
