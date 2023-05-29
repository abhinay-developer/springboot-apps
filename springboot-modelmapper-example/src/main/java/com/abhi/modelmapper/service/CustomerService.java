package com.abhi.modelmapper.service;

import com.abhi.modelmapper.dto.CustomerDto;
import com.abhi.modelmapper.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {

    CustomerDto saveCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(CustomerDto customerDto,Long id);
    CustomerResponse findCustomerById(Long id);
    List<CustomerResponse> findAllCustomers();
    void deleteCustomerById(Long id);
}
