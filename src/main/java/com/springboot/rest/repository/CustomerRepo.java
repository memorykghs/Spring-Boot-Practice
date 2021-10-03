package com.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.rest.entity.Customer;
import com.springboot.rest.entity.CustomerPK;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, CustomerPK>{

}
