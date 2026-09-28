package com.hamitmizrak.business.dto;

import com.hamitmizrak.audit.AuditingAwareBaseDto;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.io.Serial;
import java.io.Serializable;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

// BlogCategoryDto(1) - BlogDto(N)
public class BlogCategoryDto extends AuditingAwareBaseDto implements Serializable {

    // Serial
    @Serial
    private static final long serialVersionUID = 1L;

    // ID
    private Long categoryId;

    // categoryName
    private String categoryName;
} // end BlogCategoryDto


