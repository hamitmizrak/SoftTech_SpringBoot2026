package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.BlogDto;
import com.hamitmizrak.business.services.interfaces.IBlogServices;
import com.hamitmizrak.controller.api.interfaces.IBlogApi;
import com.hamitmizrak.data.entity.BlogEntity;
import com.hamitmizrak.error.ApiResult;
import com.hamitmizrak.utily.FrontEnd;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2


// API
@RestController
@RequestMapping("/blog/api/v1.0.0")
@CrossOrigin(origins = FrontEnd.REACT_URL)
public class BlogApiImpl  implements IBlogApi<BlogDto> {

    // DI
    // Field
    private final IBlogServices<BlogDto, BlogEntity> iBlogServices;

    /// ///////////////////////////////////////////////////////////////
    /// SPEED DATA
    /// http://localhost:5555/blog/api/v1.0.0/speed
    @Override
    @GetMapping("/speed")
    public ResponseEntity<ApiResult<List<BlogDto>>> speedData(Integer data) {
        return null;
    }

    /// DELETE DATA
    /// http://localhost:5555/blog/api/v1.0.0/delete-all
    @Override
    @GetMapping("/delete-all")
    public ResponseEntity<ApiResult<List<BlogDto>>> deleteData() {
        return null;
    }


    /// ///////////////////////////////////////////////////////////////
    /// CREATE RESIMSIZ (BLOG)
    @Override
    @PostMapping
    public ResponseEntity<ApiResult<?>> objectApiCreate(@Valid @RequestBody BlogDto blogDto) {
        return null;
    }

    /// CREATE RESIMLI (BLOG)
    @Override
    @PostMapping
    public ResponseEntity<ApiResult<?>> objectApiCreateWithFile(String json, MultipartFile multipartFile) {
        return null;
    }


    ///  LIST (BLOG)
    @Override
    @GetMapping
    public ResponseEntity<ApiResult<List<BlogDto>>> objectApiList() {
        return null;
    }

    /// FIND BY ID (BLOG)
    @Override
    @GetMapping
    public ResponseEntity<ApiResult<?>> objectApiFindById(Long id) {
        return null;
    }

    /// UPDATE RESIMLI (BLOG)
    @Override
    @PutMapping
    public ResponseEntity<ApiResult<?>> objectApiUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody BlogDto blogDto) {
        return null;
    }


    /// UPDATE RESIMSIZ (BLOG)
    @Override
    @PutMapping
    public ResponseEntity<ApiResult<?>> objectApiUpdateWithFile(@PathVariable(name = "id") Long id, String json, MultipartFile multipartFile) {
        return null;
    }

    /// DELETE (BLOG)
    @Override
    @DeleteMapping
    public ResponseEntity<ApiResult<?>> objectApiDelete(@PathVariable(name = "id") Long id) {
        return null;
    }


    /// /////////////////////////////////////////////////////////////////////
    /// PAGINATION & SORTING

    ///  PAGINATION
    @Override
    @GetMapping
    public Page<BlogDto> objectApiPagination(int currentPage, int pageSize) {
        return null;
    }

    ///  SORTING
    @Override
    @GetMapping
    public List<BlogDto> objectApiListSortedByDefault(String sortedBy) {
        return List.of();
    }

    ///  SORTING ASC
    @Override
    @GetMapping
    public List<BlogDto> objectApiListSortedByAsc() {
        return List.of();
    }

    ///  SORTING DESC
    @Override
    @GetMapping
    public List<BlogDto> objectApiListSortedByDesc() {
        return List.of();
    }
} // end BlogApiImpl
