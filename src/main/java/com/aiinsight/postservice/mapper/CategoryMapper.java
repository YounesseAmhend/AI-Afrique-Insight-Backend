package com.aiinsight.postservice.mapper;

import com.aiinsight.postservice.dto.CategoryResponseDto;
import com.aiinsight.postservice.model.Cateogory;

public class CategoryMapper {
    public static CategoryResponseDto toDto(Cateogory cateogory) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(cateogory.getId());
        dto.setName(cateogory.getName());
        return dto;
    }
}