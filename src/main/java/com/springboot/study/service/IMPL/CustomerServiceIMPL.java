package com.springboot.study.service.IMPL;

import com.springboot.study.dto.CustomerDTO;
import com.springboot.study.entity.Customer;
import com.springboot.study.repo.CustomerRepo;
import com.springboot.study.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.isActiveState()
        );

        if (!customerRepo.existsById(customer.getCustomerId())){
            customerRepo.save(customer);
        }else {
            System.out.println("customer id already exists");
        }
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        if(customerRepo.existsById(customerDTO.getCustomerId())){
            Customer customer = customerRepo.getById(customerDTO.getCustomerId());

            customer.setCustomerName(customerDTO.getCustomerName());
            customer.setCustomerAddress(customerDTO.getCustomerAddress());
            customer.setCustomerSalary(customerDTO.getCustomerSalary());

            customerRepo.save(customer);
            return "updated";
        }else {
            System.out.println("no customer found for that id");
            return "no customer found for that id";
        }
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {

        Customer customer = customerRepo.getById(customerId);
        CustomerDTO customerDTO = modelMapper.map(customer , CustomerDTO.class);

        return customerDTO;



//        Customer customer = customerRepo.getById(customerId);
//        if (customer!=null){
//            CustomerDTO customerDTO =new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getCustomerSalary(),
//                    customer.getNic(),
//                    customer.isActiveState()
//            );
//            return customerDTO;
//        }else {
//            return null;
//        }



//        Optional<Customer> customer = customerRepo.findById(customerId);
//        if (customer.isPresent()){
//            CustomerDTO customerDTO =new CustomerDTO(
//                    customer.get().getCustomerId(),
//                    customer.get().getCustomerName(),
//                    customer.get().getCustomerAddress(),
//                    customer.get().getCustomerSalary(),
//                    customer.get().getNic(),
//                    customer.get().isActiveState()
//            );
//            return customerDTO;
//        }else {
//            return null;
//        }

    }

    @Override
    public List<CustomerDTO> getAllcustomers() {
        List<Customer>getCustomers = customerRepo.findAll();
        List<CustomerDTO>customerDTOList= new ArrayList<>();

//        for(Customer customer : getCustomers){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerId(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getCustomerSalary(),
//                    customer.getNic(),
//                    customer.isActiveState()
//            );
//            customerDTOList.add(customerDTO);
//        }

        if(getCustomers!=null){
            customerDTOList=modelMapper.map(getCustomers,new TypeToken<List<CustomerDTO>>(){
            }.getType());
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)){
            customerRepo.deleteById(customerId);
            return "deleted";
        }else{
            return "no customer found for that id";
        }
    }
}
