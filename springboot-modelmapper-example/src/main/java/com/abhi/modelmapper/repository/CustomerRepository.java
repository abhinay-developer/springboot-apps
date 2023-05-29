package com.abhi.modelmapper.repository;

import com.abhi.modelmapper.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
