package com.hamitmizrak.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.business.dto.BlogDto;
import com.hamitmizrak.data.entity.BlogEntity;
import com.hamitmizrak.data.mapper.BlogMapper;
import com.hamitmizrak.data.repository.IBlogCategoryRepository;
import com.hamitmizrak.data.repository.IBlogRepository;
import com.hamitmizrak.services.interfaces.IBlogServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor //DI
@Log4j2

// SERVICE
@Service
public class BlogServicesImpl implements IBlogServices<BlogDto, BlogEntity> {

    // DI
    private final IBlogCategoryRepository iBlogCategoryRepository;
    private final IBlogRepository iBlogRepository;
    private final ModelMapperBean modelMapperBean;

    // Const
    private final BlogMapper blogMapper = new BlogMapper();


    /// ///////////////////////////////////////////////////////////////
    // METHOD
    // MODEL MAPPER
    @Override
    public BlogDto entityToDto(BlogEntity blogEntity) {
        // 1.YOL
        // return modelMapperBean.modelMapperMethod().map(blogCategoryEntity, BlogCategoryDto.class);

        // 2.YOL
        return blogMapper.toDto(blogEntity);
    }

    @Override
    public BlogEntity dtoToEntity(BlogDto blogDto) {
        // 1.YOL
        // return modelMapperBean.modelMapperMethod().map(blogDto, BlogCategoryEntity.class);

        // 2.YOL
        return blogMapper.toEntity(blogDto);
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
    public BlogDto objectServiceFindById(Long id) {
        return null;
    }

    @Override
    public BlogDto objectServiceUpdate(Long id, BlogDto blogDto) {
        return null;
    }

    @Override
    public BlogDto objectServiceDelete(Long id) {
        return null;
    }

    /// ////////////////////////////////////////////////////////////////
    // IMAGE
    @Override
    public BlogDto objectServiceCreateWithFile(BlogDto blogDto, MultipartFile multipartFile) {
        return null;
    }

    @Override
    public BlogDto objectServiceUpdateWithFile(Long id, BlogDto blogDto, MultipartFile multipartFile) {
        return null;
    }


    /// ////////////////////////////////////////////////////////////////
    // PAGINATION & SORTING
    @Override
    public Page<BlogDto> objectServicePagination(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public List<BlogDto> objectServiceListSortedByDefault(String sortedBy) {
        return List.of();
    }

    @Override
    public List<BlogDto> objectServiceListSortedByAsc() {
        return List.of();
    }

    @Override
    public List<BlogDto> objectServiceListSortedByDesc() {
        return List.of();
    }

} // end BlogServicesImpl
