package com.hamitmizrak.audit;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// LOMBOK
@Getter
@Setter

/**
 Sisteme giriş yapmış kişinin bir tabloya ekleme, güncelleme yaptığında
 Database eklenecek kısımdır.
 */
abstract public class AuditingAwareBaseDto {

    // Kim Ekledi
    private String createdBy;

    // Kim Ne zaman Ekledi
    private Date createdDate;

    // Kim Güncelledi
    private String lastUserBy;

    // Kim Ne Zaman Güncelledi
    private Date lastUserDate;
}
