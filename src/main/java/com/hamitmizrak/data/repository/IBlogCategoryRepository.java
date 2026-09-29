package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.BlogCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// CrudRepository
@Repository
public interface IBlogCategoryRepository extends JpaRepository<BlogCategoryEntity, Long> {

    // 1-Delived Query(Basit Sorgu): ==> Spring metot isimlerinden kullanarak SQL Sorguları üretiriz.
    /*
    Spring Data, JPA metot isimlerini otomatik olarka SQL/JPQL sorgusunu oluşturur.
    exists: KAyıt var mı ?
    IgnoreCase: Büyük/Küçük harfe duyarsız
    */
    boolean existsByCategoryNameIgnoreCase(String categoryName); // Büyük küçük harfe bakmadan bu kategori adı var mı
    Optional<BlogCategoryEntity> findByCategoryNameIgnoreCase(String categoryName); // Büyük küçük harfe bakmadan Kategori bul

    List<BlogCategoryEntity> findAllByOrderByCategoryNameAsc();  // Küçükten büyüğe sırala
    List<BlogCategoryEntity> findAllByOrderByCategoryNameDesc(); // Büyükten küçüğe sırala

    List<BlogCategoryEntity> findByCategoryNameContainingIgnoreCase(String categoryName); // SQL ==> '%java%'
    List<BlogCategoryEntity> findByCategoryNameStartingWithIgnoreCase(String categoryName); // SQL ==> 'java%'
    List<BlogCategoryEntity> findByCategoryNameEndingWithIgnoreCase(String categoryName); // SQL ==> '%java'

    // 2-JPQL(Karmaşık Sorgular): ==> Entity + Java Field isimlerini kullanarak SQL Sorguları üretiriz.
    @Query("""
        SELECT  category
        FROM BlogCategoryEntity category
        WHERE LOWER(category.categoryName) = LOWER(:categoryName)
        """)
    Optional<BlogCategoryEntity> findCategoryByNameJpql(@Param("categoryName") String categoryName);

    @Query("""
        SELECT  category
        FROM BlogCategoryEntity category
        ORDER BY category.categoryName ASC
        """)
    Optional<BlogCategoryEntity> findAllCategoriesOrderByNameJpql();

    @Query("""
        SELECT  category
        FROM BlogCategoryEntity category
        WHERE LOWER(category.categoryName)
        LIKE LOWER(CONCAT('%', :categoryName, '%'))
        """)
    Optional<BlogCategoryEntity> searchCategoryByNameJpql(@Param("categoryName") String categoryName);

    // 3-Native Query: ==> Gerçek Database tablo + kolon isimlerini kullanarak SQL Sorguları üretiriz.
}
