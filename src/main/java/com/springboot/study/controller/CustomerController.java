package com.springboot.study.controller;

import com.springboot.study.dto.CustomerDTO;
import com.springboot.study.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(
            path = "/get-by-id",
            params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }


    @GetMapping(path = "/get-all-customer")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllcustomers();
        return allCustomers;
    }

    @DeleteMapping(path = "/delete-customer/{id}")
    public String deleleCustomer(@PathVariable(value = "id" ) int customerId){
        String deleted = customerService.deleteCustomer(customerId);
        return deleted;
    }
}
