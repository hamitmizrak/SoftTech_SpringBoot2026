package com.hamitmizrak.data.mapper;

public interface IGenericMapper<DTO,ENTITY> {

    DTO toDto(ENTITY entity);
    ENTITY toEntity(DTO dto);
}
