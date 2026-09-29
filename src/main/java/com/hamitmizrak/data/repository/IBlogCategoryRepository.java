package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.BlogCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// CrudRepository
@Repository
public interface IBlogCategoryRepository extends JpaRepository<BlogCategoryEntity, Long> {

    // Delivery Query
    boolean existsByCategoryNameIgnoreCase(String categoryName);

    Optional<BlogCategoryEntity> findByCategoryNameIgnoreCase(String categoryName);
}
