package com.hamitmizrak.controller.api.impl;

import com.hamitmizrak.business.dto.BlogCategoryDto;
import com.hamitmizrak.business.services.interfaces.IBlogCategoryServices;
import com.hamitmizrak.controller.api.interfaces.IBlogCategoryApi;
import com.hamitmizrak.data.entity.BlogCategoryEntity;
import com.hamitmizrak.utily.FrontEnd;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
} // end BlogCategoryApiImpl
