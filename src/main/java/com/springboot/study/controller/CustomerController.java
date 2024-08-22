package com.springboot.study.controller;

import com.springboot.study.dto.CustomerDTO;
import com.springboot.study.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.addCustomer(customerDTO);
        return "saved";
    }

    @PostMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerDTO customerDTO){
        String update = customerService.updateCustomer(customerDTO);
        return update;
    }
}
