package com.hamitmizrak.controller.api;

import org.springframework.data.domain.Page;

import java.util.List;

// D: Dto
public interface ISortingPagingApi<D> {

    // SORTING AND PAGING
    // PAGINATION
    public Page<D> objectApiPagination(int currentPage, int pageSize);

    // SORTING
    // DAtabase içinde herhangi bir kolona göre sıralama yapsın
    public List<D> objectApiListSortedByDefault(String sortedBy);
    public  List<D> objectApiListSortedByAsc();
    public  List<D> objectApiListSortedByDesc();
}
