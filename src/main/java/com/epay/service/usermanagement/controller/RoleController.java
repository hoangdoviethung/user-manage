package com.epay.service.usermanagement.controller;

import com.epay.service.usermanagement.entitys.Role;
import com.epay.service.usermanagement.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@CrossOrigin("*")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<Role>> getAllRoles(@PageableDefault Pageable pageable) {
        Page<Role> roles = roleService.getAllRoles(pageable);
        return ResponseEntity.ok().body(roles);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        if (role == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(role);
    }

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        Role createdRole = roleService.saveRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
    }

    @PutMapping("/update")
    public ResponseEntity<Role> updateRole(@RequestBody Role Role) {
        Role existingRole = roleService.getRoleById(Role.getId());
        if (existingRole == null) {
            return ResponseEntity.notFound().build();
        }

        Role role = new Role();
        BeanUtils.copyProperties(Role, role);
        Role updatedRole = roleService.saveRole(role);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        Role existingRole = roleService.getRoleById(id);
        if (existingRole == null) {
            return ResponseEntity.notFound().build();
        }
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
