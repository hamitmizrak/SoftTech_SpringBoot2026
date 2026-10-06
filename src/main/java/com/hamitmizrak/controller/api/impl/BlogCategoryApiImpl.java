package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.BlogCategoryDto;
import com.hamitmizrak.business.services.interfaces.IBlogCategoryServices;
import com.hamitmizrak.controller.api.interfaces.IBlogCategoryApi;
import com.hamitmizrak.data.entity.BlogCategoryEntity;
import com.hamitmizrak.error.ApiResult;
import com.hamitmizrak.utily.FrontEnd;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// API
@RestController
@RequestMapping("/blog/category/api/v1.0.0")
@CrossOrigin(origins = FrontEnd.REACT_URL)
public class BlogCategoryApiImpl implements IBlogCategoryApi<BlogCategoryDto> {

    // Field
    private final IBlogCategoryServices<BlogCategoryDto, BlogCategoryEntity> iBlogCategoryServices;


    /// ///////////////////////////////////////////
    /// SPEED
    // http://localhost:5555/blog/category/api/v1.0.0/speed
    @GetMapping("/speed")
    @Override
    public ResponseEntity<ApiResult<List<BlogCategoryDto>>> speedData(Integer data) {
        return ResponseEntity.ok(ApiResult.success(iBlogCategoryServices.speedData(data)));
    }

    // DELETE ALL
    // http://localhost:5555/blog/category/api/v1.0.0/delete-all
    @GetMapping("/delete-all")
    @Override
    public ResponseEntity<ApiResult<List<BlogCategoryDto>>> deleteData() {
        return ResponseEntity.ok(ApiResult.success(iBlogCategoryServices.deleteData()));
    }

    /// ///////////////////////////////////////////
    /// BLOG CATEGORY CREATE
    // http://localhost:5555/blog/category/api/v1.0.0/create
    @PostMapping("/create")
    @Override
    public ResponseEntity<ApiResult<?>> objectApiCreate(@Valid @RequestBody BlogCategoryDto blogCategoryDto) {
        try {
            return ResponseEntity.ok(ApiResult.success(iBlogCategoryServices.objectServiceCreate(blogCategoryDto)));
        }catch (Exception ex){
            return ResponseEntity.ok(ApiResult.error("serverError", ex.getMessage(),"/blog/category/api/v1.0.0/create"));
        }
    }

    // BLOG_CATEGORY LIST
    // http://localhost:5555/blog/category/api/v1.0.0/list
    @GetMapping("/list")
    @Override
    public ResponseEntity<ApiResult<List<BlogCategoryDto>>> objectApiList() {
        try {
            return ResponseEntity.ok(ApiResult.success(iBlogCategoryServices.objectServiceList()));
        }catch (Exception ex){
            return ResponseEntity.ok(ApiResult.error("serverError", ex.getMessage(),"/blog/category/api/v1.0.0/liste"));
        }
    }

    // BLOG_CATEGORY FIND
    // http://localhost:5555/blog/category/api/v1.0.0/find/1
    @GetMapping("find/{id}")
    @Override
    public ResponseEntity<ApiResult<?>> objectApiFindById(@PathVariable(name="id") Long id) {
        try {
            return ResponseEntity.ok(ApiResult.success(iBlogCategoryServices.objectServiceFindById(id)));
        }catch (Exception ex){
            return ResponseEntity.ok(ApiResult.error("serverError", ex.getMessage(),"/blog/category/api/v1.0.0/find/1"));
        }
    }

    // BLOG_CATEGORY UPDATE
    // http://localhost:5555/blog/category/api/v1.0.0/update/1
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<ApiResult<?>> objectApiUpdate(@PathVariable(name="id") Long id, @Valid @RequestBody BlogCategoryDto blogCategoryDto) {
        try {
            return ResponseEntity.ok(ApiResult.success(iBlogCategoryServices.objectServiceUpdate(id, blogCategoryDto)));
        }catch (Exception ex){
            return ResponseEntity.ok(ApiResult.error("serverError", ex.getMessage(),"blog/category/api/v1.0.0/update/1"));
        }
    }

    // BLOG_CATEGORY DELETE
    // http://localhost:5555/blog/category/api/v1.0.0/delete/1
    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<ApiResult<?>> objectApiDelete(@PathVariable(name="id") Long id) {
        try {
            return ResponseEntity.ok(ApiResult.success(iBlogCategoryServices.objectServiceDelete(id)));
        }catch (Exception ex){
            return ResponseEntity.ok(ApiResult.error("serverError", ex.getMessage(),"blog/category/api/v1.0.0/delete/1"));
        }
    }

} // end BlogCategoryApiImpl
