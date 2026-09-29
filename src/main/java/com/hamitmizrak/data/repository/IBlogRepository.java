package com.hamitmizrak.data.repository;

import com.hamitmizrak.data.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// CrudRepository
@Repository
public interface IBlogRepository extends JpaRepository<BlogEntity, Long> {

    // Delivery Query

}
