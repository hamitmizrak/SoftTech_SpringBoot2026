package com.hamitmizrak.services.impl;

import com.hamitmizrak.business.dto.BlogDto;
import com.hamitmizrak.data.entity.BlogEntity;
import com.hamitmizrak.services.interfaces.IBlogCategoryServices;
import com.hamitmizrak.services.interfaces.IBlogServices;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// LOMBOK
// @RequiredArgsConstructor //DI
@Log4j2

// SERVICE
@Service
public class BlogCategoryServicesImpl implements IBlogCategoryServices<BlogDto, BlogEntity> {

    // DI

    // METHOD
    // MODEL MAPPER
    @Override
    public BlogDto entityToDto(BlogEntity blogEntity) {
        return null;
    }

    @Override
    public BlogEntity dtoToEntity(BlogDto e) {
        return null;
    }

    /// ////////////////////////////////////////////////////////////////
    // SPEED DATA
    @Override
    public List<BlogDto> speedData(Integer data) {
        return List.of();
    }

    @Override
    public List<BlogDto> deleteData() {
        return List.of();
    }

    /// ////////////////////////////////////////////////////////////////
    // CRUD
    @Override
    public BlogDto objectServiceCreate(BlogDto blogDto) {
        return null;
    }

    @Override
    public List<BlogDto> objectServiceList() {
        return List.of();
    }

    @Override
    public List<BlogDto> objectServiceFindById(Long id) {
        return List.of();
    }

    @Override
    public BlogDto objectServiceUpdate(Long id, BlogDto blogDto) {
        return null;
    }

    @Override
    public BlogDto objectServiceDelete(Long id) {
        return null;
    }


} // end BlogServicesImpl
