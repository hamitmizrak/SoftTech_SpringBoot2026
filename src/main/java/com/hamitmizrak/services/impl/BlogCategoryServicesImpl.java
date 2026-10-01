package com.hamitmizrak.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.business.dto.BlogCategoryDto;
import com.hamitmizrak.data.entity.BlogCategoryEntity;
import com.hamitmizrak.data.mapper.BlogCategoryMapper;
import com.hamitmizrak.data.repository.IBlogCategoryRepository;
import com.hamitmizrak.services.interfaces.IBlogCategoryServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

// LOMBOK
 @RequiredArgsConstructor //DI
@Log4j2

// SERVICE
@Service
public class BlogCategoryServicesImpl implements IBlogCategoryServices<BlogCategoryDto, BlogCategoryEntity> {

    // DI
    /*
    1.YOL:  Field Injection
    @Autowired
    private IBlogCategoryRepository iBlogCategoryRepository;
    */

    /*
    2.YOL: Constructor Injection
     private final IBlogCategoryRepository iBlogCategoryRepository;
    @Autowired
    public BlogCategoryServicesImpl(IBlogCategoryRepository iBlogCategoryRepository) {
        this.iBlogCategoryRepository = iBlogCategoryRepository;
    }
    */

    /*
    3.YOL LOMBOK
    */
    private final IBlogCategoryRepository iBlogCategoryRepository;
    private final ModelMapperBean modelMapperBean;

    /// ///////////////////////////////////////////////////////////////
    // Const
    private final BlogCategoryMapper blogCategoryMapper= new BlogCategoryMapper();


    /// ///////////////////////////////////////////////////////////////
    // METHOD
    // MODEL MAPPER
    @Override
    public BlogCategoryDto entityToDto(BlogCategoryEntity blogCategoryEntity) {
        // 1.YOL
        // return modelMapperBean.modelMapperMethod().map(blogCategoryEntity, BlogCategoryDto.class);

        // 2.YOL
        return blogCategoryMapper.toDto(blogCategoryEntity);
    }

    @Override
    public BlogCategoryEntity dtoToEntity(BlogCategoryDto blogCategoryDto) {
        // 1.YOL
        // return modelMapperBean.modelMapperMethod().map(blogCategoryDto, BlogCategoryEntity.class);

        // 2.YOL
        return blogCategoryMapper.toEntity(blogCategoryDto);
    }

    /// ////////////////////////////////////////////////////////////////
    // SPEED DATA
    @Override
    public List<BlogCategoryDto> speedData(Integer data) {
        return List.of();
    }

    @Override
    public List<BlogCategoryDto> deleteData() {
        return List.of();
    }

    /// ////////////////////////////////////////////////////////////////
    // CRUD
    @Override
    public BlogCategoryDto objectServiceCreate(BlogCategoryDto blogDto) {
        return null;
    }

    @Override
    public List<BlogCategoryDto> objectServiceList() {
        return List.of();
    }

    @Override
    public List<BlogCategoryDto> objectServiceFindById(Long id) {
        return List.of();
    }

    @Override
    public BlogCategoryDto objectServiceUpdate(Long id, BlogCategoryDto blogDto) {
        return null;
    }

    @Override
    public BlogCategoryDto objectServiceDelete(Long id) {
        return null;
    }


} // end BlogServicesImpl
