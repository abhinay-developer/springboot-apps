package com.abhi.modelmapper.service.impl;

import com.abhi.modelmapper.dto.CustomerDto;
import com.abhi.modelmapper.dto.CustomerResponse;
import com.abhi.modelmapper.entity.Customer;
import com.abhi.modelmapper.exception.CustomerIdNotFoundException;
import com.abhi.modelmapper.repository.CustomerRepository;
import com.abhi.modelmapper.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerIdNotFoundException("Customer Id Not Found:" + id));
        customer.setUsername(customerDto.getUsername());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        Customer updateTheCustomer = customerRepository.save(customer);
        CustomerDto updatedCustomer = modelMapper.map(updateTheCustomer, CustomerDto.class);
        return updatedCustomer;
    }

    @Override
    public CustomerResponse findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerIdNotFoundException("Customer Id Not Found:" + id));
        CustomerResponse customerResponse = modelMapper.map(customer, CustomerResponse.class);
        return customerResponse;
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponse> customerResponseList = customerList.stream().map((customer) -> modelMapper.map(customer, CustomerResponse.class)).collect(Collectors.toList());
        return customerResponseList;
    }

    @Override
    public void deleteCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerIdNotFoundException("Customer Id Not Found:" + id));
        customerRepository.deleteById(id);
    }
}
