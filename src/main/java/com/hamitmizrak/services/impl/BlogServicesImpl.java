package com.hamitmizrak.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.business.dto.BlogDto;
import com.hamitmizrak.data.entity.BlogCategoryEntity;
import com.hamitmizrak.data.entity.BlogEntity;
import com.hamitmizrak.data.mapper.BlogMapper;
import com.hamitmizrak.data.repository.IBlogCategoryRepository;
import com.hamitmizrak.data.repository.IBlogRepository;
import com.hamitmizrak.exception.HamitMizrakException;
import com.hamitmizrak.exception._404_NotFoundException;
import com.hamitmizrak.file_upload.ImageService;
import com.hamitmizrak.services.interfaces.IBlogServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor //DI
@Log4j2

// SERVICE
@Service
//@Transactional
public class BlogServicesImpl implements IBlogServices<BlogDto, BlogEntity> {

    // DI
    private final IBlogCategoryRepository iBlogCategoryRepository;
    private final IBlogRepository iBlogRepository;
    private final ImageService imageService;

    // Mapper
    private final ModelMapperBean modelMapperBean;
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
    // Validation  (Not Image)
    private void validate(BlogDto blogDto, boolean isResult){
        // null
        if(blogDto==null) {
            throw new HamitMizrakException("Blog verisi boş");
        }

        if(isResult){
            if (blogDto.getHeader()==null || blogDto.getHeader().isBlank()) {
                throw new HamitMizrakException("Blog başlığı zorunludur");
            }

            if (blogDto.getContent()==null || blogDto.getContent().isBlank()) {
                throw new HamitMizrakException("Blog içeriği zorunludur");
            }
        }
    } // end validate

    // Validation  (Not Image)
    private void validateImage(BlogDto blogDto, boolean isResult){
        // null
        if(blogDto==null) {
            throw new HamitMizrakException("Blog verisi boş");
        }

        if(isResult){
            if (blogDto.getHeader()==null || blogDto.getHeader().isBlank()) {
                throw new HamitMizrakException("Blog başlığı zorunludur");
            }

            if (blogDto.getContent()==null || blogDto.getContent().isBlank()) {
                throw new HamitMizrakException("Blog içeriği zorunludur");
            }

            if (blogDto.getImage()==null || blogDto.getImage().isBlank()) {
                throw new HamitMizrakException("Blog resimi zorunludur");
            }
        }
    } // end validate

    /// ////////////////////////////////////////////////////////////////
    // CRUD
    // BLOG CREATE (RESIMSIZ)
    @Override
    @Transactional
    public BlogDto objectServiceCreate(BlogDto blogDto) {

        // validation
        validate(blogDto, true);

        // Blog'tan öncesinde kategoriye bakmak zorundayız
        Long blogCategoryId = blogDto.getBlogCategoryDto()!=null ? blogDto.getBlogCategoryDto().getBlogCategoryId():null;
        if(blogCategoryId==null) {
            throw new HamitMizrakException("=== Kategori seçiniz ===");
        }

        // blog category bul
        BlogCategoryEntity blogCategoryEntityCreate= iBlogCategoryRepository.findById(blogCategoryId).orElseThrow(()-> new _404_NotFoundException(blogCategoryId+ " id'li kategori bulunamadı"));

        // BlogEntity çağır ve BlogCategory ekle
        BlogEntity blogEntity = dtoToEntity(blogDto);
        blogEntity.setBlogCategoryEntity(blogCategoryEntityCreate);

        // Repository Save
        BlogEntity created = iBlogRepository.save(blogEntity);
        return entityToDto(created);
    }

    // BLOG CREATE (RESIMLI)
    @Override
    public BlogDto objectServiceCreateWithFile(BlogDto blogDto, MultipartFile multipartFile) {
        if(multipartFile!=null & !multipartFile.isEmpty()) {
            String relative = imageService.saveBlogImage(multipartFile);
            blogDto.setImage(relative);
        }
        return objectServiceCreate(blogDto);
    }


    /// ////////////////////////////////////////////////////////
    // BLOG LIST
    @Override
    @Transactional(readOnly = true)
    public List<BlogDto> objectServiceList() {
        return iBlogRepository.findAll().stream().map(this::entityToDto).toList();
    }

    /// ////////////////////////////////////////////////////////
    // BLOG FIND
    @Override
    @Transactional(readOnly = true)
    public BlogDto objectServiceFindById(Long id) {
        // Null
        if(id==null) {
            throw new NullPointerException("BlogDto ID null ");
        }

        // Blog Find
        BlogEntity find = iBlogRepository.findById(id)
                .orElseThrow(()-> new _404_NotFoundException("Blog id " + id + " blog bulunamadı"));
        return entityToDto(find);
    }


    /// ////////////////////////////////////////////////////////////////
    // BLOG UPDATE (RESIMSIZ)
    @Override
    @Transactional
    public BlogDto objectServiceUpdate(Long id, BlogDto blogDto) {

        // validation
        validate(blogDto, true);

        BlogEntity blogEntity =iBlogRepository.findById(id).orElseThrow(()-> new HamitMizrakException(id+ " id'li blog bulunamadı"));

        if(blogDto.getBlogCategoryDto()!=null && blogDto.getBlogCategoryDto().getBlogCategoryId()!=null) {
            Long blogCategoryId = blogDto.getBlogCategoryDto().getBlogCategoryId();
            BlogCategoryEntity blogCategoryEntity = iBlogCategoryRepository.findById(blogCategoryId).orElseThrow(()-> new HamitMizrakException(id+ " id'li blog bulunamadı"));

            blogEntity.setBlogCategoryEntity(blogCategoryEntity);
        }
        return entityToDto(blogEntity);
    }

    // BLOG UPDATE (RESIMLISIZ)
    @Override
    public BlogDto objectServiceUpdateWithFile(Long id, BlogDto blogDto, MultipartFile multipartFile) {
        BlogEntity blogEntitycurrent= iBlogRepository.findById(id).orElseThrow(()-> new HamitMizrakException(id+ " id'li blog bulunamadı"));

        // Güncelenecek resimde eski resimi silmek
        String oldImageUrl =  blogEntitycurrent.getImage();

        if(multipartFile!=null & !multipartFile.isEmpty()) {
            String relative = imageService.saveBlogImage(multipartFile);
            blogDto.setImage(relative);
        }

        BlogDto blogDtoUpdate =objectServiceUpdate(id, blogDto);

        if(multipartFile!=null && !multipartFile.isEmpty() &&
                oldImageUrl!=null && oldImageUrl.startsWith("/upload/") &&
                !oldImageUrl.equals(blogDtoUpdate.getImage())) {
            try {
                imageService.deleteByUrl(oldImageUrl);
            }catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
        return blogDtoUpdate;
    }

    /// ////////////////////////////////////////////////////////////////
    // BLOG DELETE
    @Override
    @Transactional
    public BlogDto objectServiceDelete(Long id) {

        BlogEntity findDelete = dtoToEntity(objectServiceFindById(id));

        String img = findDelete.getImage();
        if(img!=null && img.startsWith("/upload/")) {
            try {

            }catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }

        // Delete
        iBlogRepository.deleteById(id);
        return entityToDto(findDelete);
    }

    /// ////////////////////////////////////////////////////////////////
    /// ////////////////////////////////////////////////////////////////
    // PAGINATION & SORTING
    @Override
    @Transactional(readOnly = true)
    public Page<BlogDto> objectServicePagination(int currentPage, int pageSize) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlogDto> objectServiceListSortedByDefault(String sortedBy) {
        return List.of();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlogDto> objectServiceListSortedByAsc() {
        return List.of();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlogDto> objectServiceListSortedByDesc() {
        return List.of();
    }


    // application.properties ANLAT
} // end BlogServicesImpl
