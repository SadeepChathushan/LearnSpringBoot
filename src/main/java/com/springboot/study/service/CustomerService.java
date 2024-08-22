package com.springboot.study.service;

import com.springboot.study.dto.CustomerDTO;

public interface CustomerService  {
    void addCustomer(CustomerDTO customerDTO);

    String updateCustomer(CustomerDTO customerDTO);
}
