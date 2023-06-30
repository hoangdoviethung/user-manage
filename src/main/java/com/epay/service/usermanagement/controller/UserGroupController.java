package com.epay.service.usermanagement.controller;

import com.epay.service.usermanagement.dto.UserGroupDTO;
import com.epay.service.usermanagement.entitys.UserGroup;
import com.epay.service.usermanagement.service.UserGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userGroups")
@CrossOrigin("*")
public class UserGroupController {

    private final UserGroupService userGroupService;

    @Autowired
    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<UserGroupDTO>> getAllUserGroups(@PageableDefault Pageable pageable) {
        Page<UserGroupDTO> userGroups = userGroupService.getAllUserGroups(pageable);
        return ResponseEntity.ok(userGroups);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<UserGroupDTO> getUserGroupById(@PathVariable Long id) {
        UserGroupDTO userGroup = userGroupService.getUserGroupById(id);
        if (userGroup == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userGroup);
    }

    @PostMapping("/create")
    public ResponseEntity<UserGroup> createUserGroup(@RequestBody UserGroup userGroup) {
        UserGroup createdUserGroup = userGroupService.saveUserGroup(userGroup);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserGroup);
    }

    @PutMapping("/update")
    public ResponseEntity<UserGroup> updateUserGroup(@RequestBody UserGroupDTO userGroupDTO) {
        UserGroupDTO existingUserGroup = userGroupService.getUserGroupById(userGroupDTO.getId());
        if (existingUserGroup == null) {
            return ResponseEntity.notFound().build();
        }

        UserGroup userGroup = new UserGroup();

        BeanUtils.copyProperties(userGroupDTO, userGroup);
        UserGroup updatedUserGroup = userGroupService.saveUserGroup(userGroup);
        return ResponseEntity.ok(updatedUserGroup);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserGroup(@PathVariable Long id) {
        UserGroupDTO existingUserGroup = userGroupService.getUserGroupById(id);
        if (existingUserGroup == null) {
            return ResponseEntity.notFound().build();
        }
        userGroupService.deleteUserGroup(id);
        return ResponseEntity.noContent().build();
    }
}

