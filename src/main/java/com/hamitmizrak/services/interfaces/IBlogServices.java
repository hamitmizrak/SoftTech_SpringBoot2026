package com.hamitmizrak.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// D: Dto
// E: Entity
public interface IBlogServices<D,E> {

    // MODELMAPPER
    public D entityToDto(E e);
    public E dtoToEntity(D e);


    // SPEED CREATE & DELETE
    // SPEED DATA
    public List<D> speedData(Integer data);

    // DELETE ALL
    public List<D> deleteData();

    // CRUD
    // CREATE
    public D objectServiceCreate(D d);

    // LIST
    public List<D>  objectServiceList();

    // FIND BY ID
    public List<D>  objectServiceFindById(Long id);

    // UPDATE
    public D objectServiceUpdate(Long id, D d);

    // DELETE
    public D objectServiceDelete(Long id);


    // IMAGE
    // IMAGE CREATE
    public D objectServiceCreateWithFile(D d, MultipartFile multipartFile);

    // IMAGE UPDATE
    public D objectServiceUpdateWithFile(Long id, D d, MultipartFile multipartFile);


    // SORTING AND PAGING
    // PAGINATION
    public Page<D> objectServicePagination(int currentPage, int pageSize);

    // SORTING
    // DAtabase içinde herhangi bir kolona göre sıralama yapsın
    public  List<D> objectServiceListSortedByDefault(String sortedBy);
    public  List<D> objectServiceListSortedByAsc();
    public  List<D> objectServiceListSortedByDesc();
}
