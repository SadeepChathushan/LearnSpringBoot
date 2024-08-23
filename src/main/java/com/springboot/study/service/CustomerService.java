package com.springboot.study.service;

import com.springboot.study.dto.CustomerDTO;

import java.util.List;

public interface CustomerService  {
    void addCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);


    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllcustomers();

    String deleteCustomer(int customerId);
}
