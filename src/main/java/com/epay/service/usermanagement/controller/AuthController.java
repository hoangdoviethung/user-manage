package com.epay.service.usermanagement.controller;


//import com.epay.service.usermanagement.config.ConfigLoad;

import com.epay.service.usermanagement.config.ConfigLoad;
import com.epay.service.usermanagement.dto.request.LoginRequest;
import com.epay.service.usermanagement.dto.request.SignupRequest;
import com.epay.service.usermanagement.dto.response.MessageResponse;
import com.epay.service.usermanagement.security.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author duantp
 */

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private ConfigLoad configLoad;

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateConsumer(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<MessageResponse> registerConsumer(@RequestBody SignupRequest signupRequest) {
        return authService.registerConsumer(signupRequest);
    }

    @GetMapping("/load-config")
    public void loadConfig() {
        configLoad.init();
    }

}
