package com.hamitmizrak.controller.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.http.MediaType;
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


    /// ////////////////////////////////////////////////////////////////////
    // PAGINATION/SORTING
    /*
     PathVariable ve RequestParam Arasındaki Farklar

    | Özellik             | @PathVariable                                         | @RequestParam                                   |
    |-------------------------------------------------------|----------------------------------------------------|
    | Amaç                | URL yolundaki bir parametreyi alır.                   | Sorgu parametrelerini (query parameters) alır.     |
    | Kullanım Yeri       | URL'nin bir parçası olarak tanımlanır.                | URL'deki `?` işaretinden sonra gelen parametrelerle çalışır. |
    | URL Örneği          | `/api/users/{id}`                                     | `/api/users?name=Hamit`                             |
    | Tanımlama Şekli     | `@PathVariable("id") Long id`                         | `@RequestParam("name") String name`               |
    | Zorunluluk          | Varsayılan olarak zorunludur (opsiyonel yapılabilir). | Varsayılan olarak zorunludur (opsiyonel yapılabilir).|
    | Çoklu Değerler      | Sadece tek bir değer alır.                            | Birden fazla parametreyi kolayca alabilir.         |

     Örnekler
     @PathVariable Kullanımı
    URL: `/api/users/123`

    @GetMapping("/api/users/{id}")
    public ResponseEntity<String> getUserById(@PathVariable("id") Long id) {
        return ResponseEntity.ok("User ID: " + id);
    }

    @RequestParam Kullanımı
    URL: `/api/users?name=Hamit`


    @GetMapping("/api/users")
    public ResponseEntity<String> getUserByName(@RequestParam("name") String name) {
        return ResponseEntity.ok("User Name: " + name);
    }
    ---

     Temel Fark
    - @PathVariable, dinamik bir URL'nin bir parçasını temsil eder.
    - @RequestParam, sorgu parametrelerini alır ve genelde isteğe bağlı parametreler için kullanılır.

    Hangi Durumda Kullanılır?
    - @PathVariable: Kaynak kimliğini veya bir URL'nin parçasını almak için.
    - @RequestParam: Filtreleme, sıralama veya arama gibi isteğe bağlı parametrelerle çalışmak için.
  */
    /// PAGINATION & SORTING
    /// PAGINATION
    // 1.sayfada 4 tane veri getir.
    // http://localhost:5555//blog/api/v1.0.0/pagination?current_page=0&page_size=4
    @Override
    @GetMapping(value = "/pagination")
    public ResponseEntity<Page<?>> objectApiPagination(
            @RequestParam(name="current_page", required = false,defaultValue = "0") int currentPage,
            @RequestParam(name="page_size", required = false,defaultValue = "0") int pageSize) {
        return ResponseEntity.ok(iBlogServices.objectServicePagination(currentPage, pageSize));
    }

    ///  SORTING
    // SORTING (Belli Sutuna göre)
    // Dikkat: Embedded için gerekli Entity ismini yanlış yazma
    // @Embedded
    // private AddressEntityDetailsEmbeddable detailsEmbeddable;
    // http://localhost:4444/api/address/v1.0.0/sorting?sorted_by=detailsEmbeddable.city
    // http://localhost:4444/api/address/v1.0.0/sorting?sorted_by=detailsEmbeddable.state
    // http://localhost:4444/api/address/v1.0.0/sorting?sorted_by=detailsEmbeddable.street
    @Override
    @GetMapping(value = "/sorting")
    public ResponseEntity<List<BlogDto>> objectApiListSortedByDefault(
            @RequestParam(name="sorted_by", required = false,defaultValue = "header")  String sortedBy) {
        return ResponseEntity.ok(iBlogServices.objectServiceListSortedByDefault(sortedBy));
    }

    ///  SORTING ASC
    // SORTING ASC (Küçükten büyüğe doğru)
    // http://localhost:4444/api/address/v1.0.0/sorting/header/asc
    @Override
    @GetMapping(value = "/sorting/header/asc")
    public ResponseEntity<List<BlogDto>> objectApiListSortedByAsc() {
        return ResponseEntity.ok(iBlogServices.objectServiceListSortedByAsc());
    }

    ///  SORTING DESC
    // SORTING DESC (Büyükten küçüğe doğru)
    // http://localhost:4444/api/address/v1.0.0/sorting/header/desc
    @Override
    @GetMapping(value = "/sorting/header/desc")
    public ResponseEntity<List<BlogDto>> objectApiListSortedByDesc() {
        return ResponseEntity.ok(iBlogServices.objectServiceListSortedByDesc());
    }
} // end BlogApiImpl
