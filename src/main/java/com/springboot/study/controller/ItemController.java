package com.springboot.study.controller;

import com.springboot.study.dto.ItemDTO;
import com.springboot.study.dto.request.RequestSaveItemDTO;
import com.springboot.study.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public String saveItem(@RequestBody RequestSaveItemDTO requestSaveItemDTO) {
        itemService.addItem(requestSaveItemDTO);
        return "saved";

    }


//            path = "/get-by-id",
//            params = "id")
//    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
//        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
//        return customerDTO;
//    }

    @GetMapping(path ="/get-by-name",params = "name")
    public List<ItemDTO> getItemByName(@RequestParam(value = "name") String itemName){
        List<ItemDTO> itemDTO =itemService.getItemByName(itemName);
        return itemDTO;
    }
}

