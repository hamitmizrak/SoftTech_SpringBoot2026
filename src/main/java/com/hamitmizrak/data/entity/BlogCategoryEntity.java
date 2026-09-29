package com.hamitmizrak.data.entity;

import com.hamitmizrak.audit.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.List;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

// Table
@Entity
@Table(name="blog_categories")

// BlogCategoryDto(1) - BlogDto(N)
public class BlogCategoryEntity extends AuditingAwareBaseEntity{

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="blog_category_id")
    private Long blogCategoryId;

    // categoryName
    @Column(unique = true,nullable = false,length = 250)
    private String categoryName;

   /// //////////////////////////////////////////////
    // Relation One(CMF)
    @OneToMany(mappedBy= "blogCategoryEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BlogEntity> blogEntityList;
} // end BlogCategoryEntity


