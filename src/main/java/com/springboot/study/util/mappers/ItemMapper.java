package com.springboot.study.util.mappers;

import com.springboot.study.dto.request.RequestSaveItemDTO;
import com.springboot.study.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item requestDtoToEntity(RequestSaveItemDTO requestSaveItemDTO);
}
