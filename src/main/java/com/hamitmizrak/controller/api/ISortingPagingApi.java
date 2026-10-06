package com.hamitmizrak.controller.api;

import org.springframework.data.domain.Page;

import java.util.List;

// D: Dto
// E: Entity
public interface ISortingPagingApi<D,E> {

    // SORTING AND PAGING
    // PAGINATION
    public Page<D> objectServicePagination(int currentPage, int pageSize);

    // SORTING
    // DAtabase içinde herhangi bir kolona göre sıralama yapsın
    public List<D> objectServiceListSortedByDefault(String sortedBy);
    public  List<D> objectServiceListSortedByAsc();
    public  List<D> objectServiceListSortedByDesc();
}
