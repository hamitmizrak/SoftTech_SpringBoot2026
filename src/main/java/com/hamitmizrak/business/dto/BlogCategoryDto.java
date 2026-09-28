package com.hamitmizrak.business.dto;

import com.hamitmizrak.audit.AuditingAwareBaseDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @NotEmpty(message = "{blog.header.validation.constraints.NotNull.message}")
    @Size(min = 5, max = 25, message = "{blog.header.least.validation.constraints.NotNull.message}")
    private String categoryName;
} // end BlogCategoryDto


