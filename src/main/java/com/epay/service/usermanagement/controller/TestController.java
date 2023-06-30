package com.epay.service.usermanagement.controller;


//import com.epay.service.usermanagement.config.ConfigLoad;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author duantp
 */

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestController {


    @GetMapping("/author")
    @PreAuthorize(value = "@authorizedService.preAuth('/test/report/view')")
    public String author() {
        return "Hello TechGeekNextUser : ";
    }

    @GetMapping("/author/abc")
    @PreAuthorize(value = "@authorizedService.preAuth('/author/abc')")
    public String authorAbc() {
        return "Hello TechGeekNextUser : ";
    }
}
