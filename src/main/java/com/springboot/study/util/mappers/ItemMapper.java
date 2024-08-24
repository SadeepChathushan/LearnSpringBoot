package com.springboot.study.util.mappers;

import com.springboot.study.dto.ItemDTO;
import com.springboot.study.dto.request.RequestSaveItemDTO;
import com.springboot.study.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item requestDtoToEntity(RequestSaveItemDTO requestSaveItemDTO);
    List<ItemDTO> entityListToDtoList(List<Item>items);
}
