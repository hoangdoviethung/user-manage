package com.epay.service.usermanagement.controller;
import com.epay.service.usermanagement.dto.UserDTO;
import com.epay.service.usermanagement.dto.request.UpdateGroupUserReq;
import com.epay.service.usermanagement.dto.response.AccessInformation;
import com.epay.service.usermanagement.dto.response.ErrorMessage;
import com.epay.service.usermanagement.entitys.User;
import com.epay.service.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<User>> getAllUsers(@PageableDefault Pageable pageable) {
        Page<User> users = userService.getAllUsers(pageable);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User existingUser = userService.getUserById(user.getId());
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        user.setId(existingUser.getId());
        User updatedUser = userService.saveUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-info")
    public ResponseEntity<UserDTO> getInfo(HttpServletRequest request) {
        UserDTO User = userService.getByUserName(request);
        if (User == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(User);
    }

    @GetMapping("/add-group-user")
    @PreAuthorize(value = "@authorizedService.preAuth('/users/add-group-user')")
    public ResponseEntity<ErrorMessage> addRole(@RequestBody UpdateGroupUserReq User) {
        ErrorMessage result = userService.update(User);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get-access-information")
    public ResponseEntity<AccessInformation> getAccessInformation(HttpServletRequest request) {
        AccessInformation accessInformation = userService.getAccessInformation(request);
        if (accessInformation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(accessInformation);
    }
}
