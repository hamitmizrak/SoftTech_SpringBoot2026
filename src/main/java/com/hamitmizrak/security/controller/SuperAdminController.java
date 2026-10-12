package com.hamitmizrak.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// MVC View
@Controller
public class SuperAdminController {

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @GetMapping({"/super-admin","/super-admin/dashboard"})
    public String superAdminDashboard(){
        return "super-admin";
    }
}
