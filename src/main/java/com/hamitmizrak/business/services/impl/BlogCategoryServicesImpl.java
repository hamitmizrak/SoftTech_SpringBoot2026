package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.business.dto.BlogCategoryDto;
import com.hamitmizrak.data.entity.BlogCategoryEntity;
import com.hamitmizrak.data.mapper.BlogCategoryMapper;
import com.hamitmizrak.data.repository.IBlogCategoryRepository;
import com.hamitmizrak.exception._404_NotFoundException;
import com.hamitmizrak.business.services.interfaces.IBlogCategoryServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

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
        List<BlogCategoryDto> listData= new ArrayList<>();

        if(data!=null){
            for (int i = 1; i <=data ; i++) {
                BlogCategoryEntity blogCategoryEntity = new BlogCategoryEntity();
                blogCategoryEntity.setCategoryName("category"+UUID.randomUUID().toString());
                iBlogCategoryRepository.save(blogCategoryEntity);
                listData.add(blogCategoryMapper.toDto(blogCategoryEntity));
            }
        }else {
            throw new NullPointerException("Integer null ");
        }
        return listData;
    }

    @Override
    public List<BlogCategoryDto> deleteData() {
        iBlogCategoryRepository.deleteAll();
        return objectServiceList();
    }

    /// ////////////////////////////////////////////////////////////////
    /// ////////////////////////////////////////////////////////////////
    /// Generics Validate
    private <T> void validate(T dto, Function<T,String> nameExtrator, String currentName){
        // DTO null
        if(dto==null){
            throw new NullPointerException("dto is null");
        }

        // Category name Null/Blank
        String categoryName = nameExtrator.apply(dto);
        if(categoryName==null || categoryName.isBlank()){
            throw new NullPointerException("BlogcategoryName is null");
        }

        // UPDATE sırasında mevcut isim değişmedikce duplicate sayma
        boolean sameAsCurrentName = currentName!=null && currentName.equalsIgnoreCase(categoryName);
        if(!sameAsCurrentName && iBlogCategoryRepository.existsByCategoryNameIgnoreCase(categoryName)){
            throw new NullPointerException("zaten blogCategoryDto adı bulunmaktadır");
        }

    }


    /// ////////////////////////////////////////////////////////////////
    // CRUD
    // BLOG_CATEGORY CREATE
    @Override
    @Transactional
    public BlogCategoryDto objectServiceCreate(BlogCategoryDto blogCategoryDto) {
        // Validate
        validate(blogCategoryDto, BlogCategoryDto::getCategoryName,null);

        //BlogCategoryEntity created = iBlogCategoryRepository.save(dtoToEntity(blogCategoryDto));
        //return entityToDto(created);
        return entityToDto(iBlogCategoryRepository.save(dtoToEntity(blogCategoryDto)));
    }

    // BLOG_CATEGORY LIST
    @Override
    @Transactional(readOnly = true)
    public List<BlogCategoryDto> objectServiceList() {
        return iBlogCategoryRepository.findAll().stream().map(this::entityToDto).toList();
    }

    // BLOG_CATEGORY FIND
    @Override
    @Transactional(readOnly = true)
    public BlogCategoryDto objectServiceFindById(Long id) {
        // Null
        if(id==null) {
            throw new NullPointerException("BlogCategoryDto ID null ");
        }
        BlogCategoryEntity blogCategoryEntityFindById = iBlogCategoryRepository.findById(id)
                .orElseThrow(()-> new _404_NotFoundException("BlogCategory id " + id + " blog kategori bulunamadı"));
        return entityToDto(blogCategoryEntityFindById);
    }

    // BLOG_CATEGORY UPDATE
    @Override
    @Transactional
    public BlogCategoryDto objectServiceUpdate(Long id, BlogCategoryDto blogCategoryDto) {

        // Null
        if(blogCategoryDto==null || blogCategoryDto.getCategoryName()==null || blogCategoryDto.getCategoryName().isBlank()){
            throw new NullPointerException("BlogCategoryDto adı zorunludur ");
        }

        // Tekrar eden category varsa
        if(iBlogCategoryRepository.existsByCategoryNameIgnoreCase(blogCategoryDto.getCategoryName())){
            throw new NullPointerException("Zaten BlogCategoryDto adı bulunmaktadır. ");
        }

        BlogCategoryEntity blogCategoryEntityUpdate = dtoToEntity(objectServiceFindById(id));
        blogCategoryEntityUpdate.setCategoryName(blogCategoryDto.getCategoryName());
        return entityToDto(iBlogCategoryRepository.save(blogCategoryEntityUpdate)) ;
    }

    // BLOG_CATEGORY DELETE
    @Override
    @Transactional
    public BlogCategoryDto objectServiceDelete(Long id) {
        BlogCategoryEntity categoryEntityDelete= dtoToEntity(objectServiceFindById(id));
        iBlogCategoryRepository.deleteById(id);
        return entityToDto(categoryEntityDelete);
    }

} // end BlogServicesImpl
