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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    // Sorting Default Fiedl
    private static final String DEFAULT_SORT_FIELD = "blogId";

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
    /// Generics Null Validation
    private <T> T validateNotNull(T value, String message) {
        if (value == null) {
            throw new HamitMizrakException(message);
        }
        return value;
    }

    /// Generics String Validation
    private Long validateId(Long id, String objectName) {
        validateNotNull(id, objectName + "ID boş olamaz.");

        if (id <= 0) {
            throw new HamitMizrakException(objectName + "ID 0'dan büyük olmalıdır.");
        }
        return id;
    }

    ///  Generics ValidateBlog Validation
    private BlogDto validateBlog(BlogDto blogDto, boolean imageRequired) {
        validateNotNull(blogDto, "Blog verisi boş");

        blogDto.setHeader(validateNotBlank(blogDto.getHeader(), "Blog başlığı zorunludur"));
        blogDto.setTitle(validateNotBlank(blogDto.getTitle(), "Blog title zorunludur"));
        blogDto.setContent(validateNotBlank(blogDto.getContent(), "Blog içeriği zorunludur"));

        // Eğer resim eklenecekse
        if (imageRequired) {
            blogDto.setImage(validateNotBlank(blogDto.getImage(), "Blog image zorunludur"));
        }
        return blogDto;
    }

    // Blog Category ID Validation
    private Long validateBlogCategoryId(BlogDto blogDto, boolean required) {
        validateNotNull(blogDto, "Blog verisi boş");

        Long categoryId = blogDto.getBlogCategoryDto() == null
                ? null
                : blogDto.getBlogCategoryDto().getBlogCategoryId();

        if (categoryId == null && !required) {
            return null;
        }

        return validateId(categoryId, "Blog Category");
    }

    // Blog Entity Find
    private BlogEntity findBlogEntityById(Long id) {
        Long validatedId = validateId(id, "Blog");
        return iBlogRepository.findById(validatedId)
                .orElseThrow(() -> new _404_NotFoundException(
                        "Blog id " + validatedId + " blog bulunamadı"));
    }

    // Blog Category Entity Find
    private BlogCategoryEntity findBlogCategoryEntityById(Long categoryId) {
        Long validatedCategoryId = validateId(categoryId, "Blog Category");
        return iBlogCategoryRepository.findById(validatedCategoryId)
                .orElseThrow(() -> new _404_NotFoundException(
                        validatedCategoryId + " id'li kategori bulunamadı"));
    }

    // Image Delete Helper
    private void deleteImageSafely(String imageUrl) {
        if (imageUrl == null || imageUrl.isBlank() || !imageUrl.startsWith("/upload/")) {
            return;
        }
        try {
            imageService.deleteByUrl(imageUrl);
        } catch (Exception exception) {
            log.error("Blog resmi silinemedi. imageUrl={}, message={}", imageUrl, exception.getMessage(), exception);
        }
    }

    /// Generics String Validation
    private String validateNotBlank(String value, String message) {
        if (value == null || value.isBlank()) {
            throw new HamitMizrakException(message);
        }
        return value.trim();
    }

    /// Generics Positive Number Validation
    private <N extends Number> int validatePositiveNumber(N value, String fieldName) {
        validateNotNull(value, fieldName + " boş olamaz");

        int number = value.intValue();
        if (number <= 0) {
            throw new HamitMizrakException(fieldName + " o'dan büyük olmalıdır");
        }
        return number;
    }

    // Validation  (Not Image)
    private void validate(BlogDto blogDto, boolean isResult) {
        // null
        if (blogDto == null) {
            throw new HamitMizrakException("Blog verisi boş");
        }

        if (isResult) {
            if (blogDto.getHeader() == null || blogDto.getHeader().isBlank()) {
                throw new HamitMizrakException("Blog başlığı zorunludur");
            }

            if (blogDto.getContent() == null || blogDto.getContent().isBlank()) {
                throw new HamitMizrakException("Blog içeriği zorunludur");
            }
        }
    } // end validate

    // Validation  (Not Image)
    private void validateImage(BlogDto blogDto, boolean isResult) {
        // null
        if (blogDto == null) {
            throw new HamitMizrakException("Blog verisi boş");
        }

        if (isResult) {
            if (blogDto.getHeader() == null || blogDto.getHeader().isBlank()) {
                throw new HamitMizrakException("Blog başlığı zorunludur");
            }

            if (blogDto.getContent() == null || blogDto.getContent().isBlank()) {
                throw new HamitMizrakException("Blog içeriği zorunludur");
            }

            if (blogDto.getImage() == null || blogDto.getImage().isBlank()) {
                throw new HamitMizrakException("Blog resimi zorunludur");
            }
        }
    } // end validate

    /// ////////////////////////////////////////////////////////////////
    /// ////////////////////////////////////////////////////////////////
    // SPEED DATA
    @Override
    @Transactional
    public List<BlogDto> speedData(Integer data) {
        int dataCount = validatePositiveNumber(data, " Speed Data sayısı");

        // Find first BlogCategory
        BlogCategoryEntity defaultBlogCategory = iBlogCategoryRepository.findAll().stream().findFirst().orElseThrow(() -> new _404_NotFoundException("Speed Data oluşturmak için en az 1 adet blog category olması gerekiyor."));

        for (int i = 1; i <= dataCount; i++) {
            BlogEntity blogEntity = BlogEntity.builder()
                    .header("Blog-" + System.nanoTime())
                    .title("Blog Title" + i)
                    .content("BlogContent")
                    .image(null)
                    .blogCategoryEntity(defaultBlogCategory)
                    .build();

            iBlogRepository.save(blogEntity);
        }
        return objectServiceListSortedByAsc();
    }


    // DELETE ALL
    @Override
    @Transactional
    public List<BlogDto> deleteData() {

        //Dosya Sistemlerinde blog resimlerin hepsini temizle
        iBlogRepository.findAll().forEach(blogEntity -> deleteImageSafely(blogEntity.getImage()));

        // Database kayıtlarını Temizle
        iBlogRepository.deleteAll();

        // Silme sonrasında boş liste dönsün
        return objectServiceList();
    }

    /// ////////////////////////////////////////////////////////////////
    // CRUD
    // BLOG CREATE (RESIMSIZ)
    @Override
    @Transactional
    public BlogDto objectServiceCreate(BlogDto blogDto) {

        // validation
        validate(blogDto, true);

        // Blog'tan öncesinde kategoriye bakmak zorundayız
        Long blogCategoryId = validateBlogCategoryId(blogDto,true);
        BlogCategoryEntity blogCategoryEntityCreate = findBlogCategoryEntityById(blogCategoryId);

        // BlogEnetity çağır ve BlogCategory Ekle
        BlogEntity blogEntity = dtoToEntity(blogDto);
        blogEntity.setBlogCategoryEntity(blogCategoryEntityCreate);

        // Repository Ekle
        BlogEntity created = iBlogRepository.save(blogEntity);
        return entityToDto(created);
    }

    // BLOG CREATE (RESIMLI)
    @Override
    public BlogDto objectServiceCreateWithFile(BlogDto blogDto, MultipartFile multipartFile) {

        // Validation
        validateNotNull(blogDto, "Blog verisi boş");

        if (multipartFile != null & !multipartFile.isEmpty()) {
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
        return iBlogRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    /// ////////////////////////////////////////////////////////
    // BLOG FIND
    @Override
    @Transactional(readOnly = true)
    public BlogDto objectServiceFindById(Long id) {
        return entityToDto(findBlogEntityById(id));
    }


    /// ////////////////////////////////////////////////////////////////
    // BLOG UPDATE (RESIMSIZ)
    @Override
    @Transactional
    public BlogDto objectServiceUpdate(Long id, BlogDto blogDto) {

        // validation
        validate(blogDto, true);

        // Blog Find
        BlogEntity blogEntity = findBlogEntityById(id);

        // DTO => Existing Entity Update
        blogEntity.setHeader(blogDto.getHeader());
        blogEntity.setTitle(blogDto.getTitle());
        blogEntity.setContent(blogDto.getContent());

        // Yeni image geldiyse güncelle; eğer gelmediyse mevcut image korunsun
        if(blogDto.getImage() != null && !blogDto.getImage().isBlank()) {
            blogEntity.setImage(blogDto.getImage());
        }

        // Category opsiyonel olarak güncellenebilir
        Long blogCAtegoryId = validateBlogCategoryId(blogDto,true);
        if(blogCAtegoryId != null) {
            blogEntity.setBlogCategoryEntity(findBlogCategoryEntityById(blogCAtegoryId));
        }

        // Update
        BlogEntity updated = iBlogRepository.save(blogEntity);
        return entityToDto(updated);
    }

    // BLOG UPDATE (RESIMLISIZ)
    @Override
    public BlogDto objectServiceUpdateWithFile(Long id, BlogDto blogDto, MultipartFile multipartFile) {

        validateNotNull(blogDto, "Blog verisi boş");

        BlogEntity currentBlogEntity = findBlogEntityById(id);

        // Güncelenecek resimde eski resimi silmek
        String oldImageUrl = currentBlogEntity.getImage();

        if (multipartFile != null & !multipartFile.isEmpty()) {
            String relative = imageService.saveBlogImage(multipartFile);
            blogDto.setImage(relative);
        }

        BlogDto blogDtoUpdate = objectServiceUpdate(id, blogDto);

        if (multipartFile != null
                && !multipartFile.isEmpty()
                && oldImageUrl != null
                && oldImageUrl.startsWith("/upload/") &&
                !oldImageUrl.equals(blogDtoUpdate.getImage())) {
            deleteImageSafely(oldImageUrl);
        }
        return blogDtoUpdate;
    }

    /// ////////////////////////////////////////////////////////////////
    // BLOG DELETE
    @Override
    @Transactional
    public BlogDto objectServiceDelete(Long id) {

        BlogEntity findDelete = dtoToEntity(objectServiceFindById(id));
        BlogDto blogDto = entityToDto(findDelete);

        // Önce DB kaydını Sil
        iBlogRepository.deleteById(id);

        // Sonra ilişkili upload dosyasını güvenli bir şekilde temizle
        deleteImageSafely(findDelete.getImage());

        return entityToDto(findDelete);
    }

    /// ////////////////////////////////////////////////////////////////
    /// ////////////////////////////////////////////////////////////////
    // PAGINATION & SORTING
    @Override
    @Transactional(readOnly = true)
    public Page<BlogDto> objectServicePagination(int currentPage, int pageSize) {
        if (currentPage < 0) {
            throw new HamitMizrakException(currentPage + " currentPage 0 veya daha büyük olmaldıır");
        }
        validatePositiveNumber(pageSize, "Page Size");

        // Pageable
        Pageable pageable = PageRequest.of(
                currentPage,
                pageSize,
                Sort.by(Sort.Direction.ASC, DEFAULT_SORT_FIELD));

        return iBlogRepository.findAll(pageable)
                .map(this::entityToDto);
    }

    // FILTRELEME()
    @Override
    @Transactional(readOnly = true)
    public List<BlogDto> objectServiceListSortedByDefault(String sortedBy) {
        String validatedSortedBy = validateNotBlank(sortedBy, "Sıralama alanı zorunludur");

        return iBlogRepository
                .findAll(Sort.by(Sort.Direction.ASC, validatedSortedBy))
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    // // Default olan blogID'e göre küçükten büyüğe  doğru sıralansın
    @Override
    @Transactional(readOnly = true)
    public List<BlogDto> objectServiceListSortedByAsc() {
        return iBlogRepository
                .findAll(Sort.by(Sort.Direction.ASC, DEFAULT_SORT_FIELD))
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    // Default olan blogID'e göre büyükten küçüğe doğru sıralansın
    @Override
    @Transactional(readOnly = true)
    public List<BlogDto> objectServiceListSortedByDesc() {
        return iBlogRepository
                .findAll(Sort.by(Sort.Direction.DESC, DEFAULT_SORT_FIELD))
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    // application.properties ANLAT
} // end BlogServicesImpl
