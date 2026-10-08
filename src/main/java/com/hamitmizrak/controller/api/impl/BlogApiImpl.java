package com.hamitmizrak.controller.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hamitmizrak.business.dto.BlogDto;
import com.hamitmizrak.business.services.interfaces.IBlogServices;
import com.hamitmizrak.controller.api.interfaces.IBlogApi;
import com.hamitmizrak.data.entity.BlogEntity;
import com.hamitmizrak.error.ApiResult;
import com.hamitmizrak.file_upload.FileProps;
import com.hamitmizrak.utily.FrontEnd;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
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
    private final ObjectMapper objectMapper;
    //private final FileProps fileProps;
    //private final JdbcTemplate jdbcTemplate;

    /// ///////////////////////////////////////////////////////////////
    /// SPEED DATA
    /// http://localhost:5555/blog/api/v1.0.0/speed
    @Override
    @GetMapping("/speed")
    public ResponseEntity<ApiResult<List<BlogDto>>> speedData(Integer data) {
        return ResponseEntity.ok(ApiResult.success(iBlogServices.speedData(data)));
    }

    /// DELETE DATA
    /// http://localhost:5555/blog/api/v1.0.0/delete-all
    @Override
    @GetMapping("/delete-all")
    public ResponseEntity<ApiResult<List<BlogDto>>> deleteData() {
        return ResponseEntity.ok(ApiResult.success(iBlogServices.deleteData()));
    }


    /// ///////////////////////////////////////////////////////////////
    /// CREATE RESIMSIZ (BLOG)
    /// http://localhost:5555/blog/api/v1.0.0/create
    @Override
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResult<?>> objectApiCreate(@Valid @RequestBody BlogDto blogDto) {
        try{
            return ResponseEntity.ok(ApiResult.success(iBlogServices.objectServiceCreate(blogDto)));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok(ApiResult.error("serverError",ex.getMessage(),"/blog/api/v1.0.0/create"));
        }
    }

    /// CREATE RESIMLI (BLOG)
    @Override
    @PostMapping(value="/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResult<?>> objectApiCreateWithFile(
            @RequestPart("blog") String json,
            @RequestPart(value = "file",required = false) MultipartFile multipartFile) {
        try{
            BlogDto blogDto = objectMapper.readValue(json,BlogDto.class);
            return ResponseEntity.ok(ApiResult.success(iBlogServices.objectServiceCreateWithFile(blogDto,multipartFile)));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok(ApiResult.error("serverError",ex.getMessage(),"/blog/api/v1.0.0/create"));
        }
    }


    ///  LIST (BLOG)
    @Override
    @GetMapping("/list")
    public ResponseEntity<ApiResult<List<BlogDto>>> objectApiList() {
        try {
            return ResponseEntity.ok(ApiResult.success(iBlogServices.objectServiceList()));
        }catch (Exception ex){
            return ResponseEntity.ok(ApiResult.error("serverError", ex.getMessage(),"/blog/api/v1.0.0/liste"));
        }
    }

    /// FIND BY ID (BLOG)
    @Override
    @GetMapping("/find/{id}")
    public ResponseEntity<ApiResult<?>> objectApiFindById(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(ApiResult.success(iBlogServices.objectServiceFindById(id)));
        }catch (Exception ex){
            return ResponseEntity.ok(ApiResult.error("serverError", ex.getMessage(),"/blog/api/v1.0.0/find/1"));
        }
    }

    /// UPDATE RESIMSIZ (BLOG) ==> AYNI ZAMANDA MEVCUT RESİMİ KORUSU
    @Override
    @PutMapping(value ="/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResult<?>> objectApiUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody BlogDto blogDto) {
        try {
            return ResponseEntity.ok(ApiResult.success(iBlogServices.objectServiceUpdate(id,blogDto)));
        }catch (Exception ex){
            return ResponseEntity.ok(ApiResult.error("serverError", ex.getMessage(),"/blog/api/v1.0.0/find/1"));
        }
    }

    /// UPDATE RESIMLI (BLOG)
    @Override
    @PutMapping(value="/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResult<?>> objectApiUpdateWithFile(
            @PathVariable(name = "id") Long id,
            @RequestPart("blog") String json,
            @RequestPart(value = "file",required = false) MultipartFile multipartFile) {
        try{
            BlogDto blogDto = objectMapper.readValue(json,BlogDto.class);
            return ResponseEntity.ok(ApiResult.success(iBlogServices.objectServiceUpdateWithFile(id,blogDto,multipartFile)));
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.ok(ApiResult.error("serverError",ex.getMessage(),"/blog/api/v1.0.0/update"));
        }
    }

    /// DELETE (BLOG)
    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResult<?>> objectApiDelete(@PathVariable(name = "id") Long id) {
        try {
            return ResponseEntity.ok(ApiResult.success(iBlogServices.objectServiceDelete(id)));
        }catch (Exception ex){
            return ResponseEntity.ok(ApiResult.error("serverError", ex.getMessage(),"/blog/api/v1.0.0/delete/"+id));
        }
    }


    /// /////////////////////////////////////////////////////////////////////
    /// PAGINATION & SORTING
    /// PAGINATION
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
