package com.hamitmizrak.business.services;

// D: Dto
// E: Entity
public interface IModelMapperService<D,E> {
    // MODELMAPPER
    public D entityToDto(E e);
    public E dtoToEntity(D e);

}
