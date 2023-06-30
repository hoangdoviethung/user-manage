package com.epay.service.usermanagement.security.services;

import com.epay.service.usermanagement.dto.request.LoginRequest;
import com.epay.service.usermanagement.dto.request.SignupRequest;
import com.epay.service.usermanagement.dto.response.JwtResponse;
import com.epay.service.usermanagement.dto.response.MessageResponse;
import com.epay.service.usermanagement.entitys.User;
import com.epay.service.usermanagement.entitys.UserGroup;
import com.epay.service.usermanagement.entitys.UserDetailsImpl;
import com.epay.service.usermanagement.repository.UserRepository;
import com.epay.service.usermanagement.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service

public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    protected HttpSession session;

    public ResponseEntity<MessageResponse> registerConsumer(@RequestBody SignupRequest signupRequest) {
        try {

            if (userRepository.existsByUsername(signupRequest.getUsername())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse(HttpStatus.BAD_REQUEST.value(), "Error: Username is already in use!"));
            }
            User user = new User();
            user.setUsername(signupRequest.getUsername());
            user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
            user.setEnabled(true);
            user.setFullName(signupRequest.getFullName());
            userRepository.save(user);

            return ResponseEntity
                    .ok()
                    .body(new MessageResponse(HttpStatus.OK.value(), "Success"));
        } catch (Exception ex) {
            ex.printStackTrace();
            MessageResponse message = new MessageResponse(HttpStatus.BAD_REQUEST.value(), "Something wrong");
            return ResponseEntity
                    .badRequest()
                    .body(message);
        }
    }

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            Map<String, Object> generateJwt = jwtUtils.generateJwtToken(authentication);
            String jwt = String.valueOf(generateJwt.get("jwt"));
            Long expiredTime = Long.parseLong(String.valueOf(generateJwt.get("expiredTime")));
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            session.setAttribute("userlogin", userDetails);
            return ResponseEntity.ok(new JwtResponse(jwt, expiredTime));
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(new MessageResponse(500, "Username or password not correct!"), HttpStatus.UNAUTHORIZED);
        }
    }

    public User createUser(String username, String password, UserGroup group) {
        User user = new User(username, passwordEncoder.encode(password));
        user.setGroup(group);
        return user;
    }

}
