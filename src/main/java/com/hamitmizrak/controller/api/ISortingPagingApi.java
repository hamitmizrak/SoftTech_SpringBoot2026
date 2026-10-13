package com.hamitmizrak.controller.api;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

// D: Dto
public interface ISortingPagingApi<D> {

    // SORTING AND PAGING
    // PAGINATION
    public ResponseEntity<Page<?>> objectApiPagination(int currentPage, int pageSize);

    // SORTING
    // DAtabase içinde herhangi bir kolona göre sıralama yapsın
    public ResponseEntity<List<D>> objectApiListSortedByDefault(String sortedBy);
    public  ResponseEntity<List<D>> objectApiListSortedByAsc();
    public  ResponseEntity<List<D>> objectApiListSortedByDesc();
}
