package com.springboot.study.service.IMPL;

import com.springboot.study.dto.ItemDTO;
import com.springboot.study.dto.request.RequestSaveItemDTO;
import com.springboot.study.entity.Item;
import com.springboot.study.repo.ItemRepo;
import com.springboot.study.service.ItemService;
import com.springboot.study.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public void addItem(RequestSaveItemDTO requestSaveItemDTO) {
//        Item item = modelMapper.map(requestSaveItemDTO,Item.class);
//        item.setActiveState(false);
//        if(!itemRepo.existsById(item.getItemId())){
//            itemRepo.save(item);
//        }

        Item item =itemMapper.requestDtoToEntity(requestSaveItemDTO);
        item.setActiveState(false);
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
        }
    }

    @Override
    public List<ItemDTO> getItemByName(String itemName) {
      List<Item>items =itemRepo.findAllByItemNameIs(itemName);
//        List<Item>items =itemRepo.findAllByItemNameEqual(itemName);

        List<ItemDTO> itemDTOS =itemMapper.entityListToDtoList(items);
        return itemDTOS;
    }


}
