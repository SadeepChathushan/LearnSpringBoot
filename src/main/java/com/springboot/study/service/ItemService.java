package com.springboot.study.service;

import com.springboot.study.dto.ItemDTO;
import com.springboot.study.dto.request.RequestSaveItemDTO;

import java.util.List;

public interface ItemService {

    void addItem(RequestSaveItemDTO itemDTO);

    List<ItemDTO> getItemByName(String itemName);
}
