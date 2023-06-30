package com.epay.service.usermanagement.controller;
import com.epay.service.usermanagement.entitys.Permission;
import com.epay.service.usermanagement.service.PermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permissions")
@CrossOrigin("*")
public class PermissionController {

    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/get-all")
    public ResponseEntity<Page<Permission>> getAllPermissions(@PageableDefault Pageable pageable) {
        Page<Permission> permissions = permissionService.getAllPermissions(pageable);
        return ResponseEntity.ok().body(permissions);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable Long id) {
        Permission permission = permissionService.getPermissionById(id);
        if (permission == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(permission);
    }

    @PostMapping("/create")
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        Permission createdPermission = permissionService.savePermission(permission);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPermission);
    }

    @PutMapping("/update")
    public ResponseEntity<Permission> updatePermission(@RequestBody Permission Permission) {
        Permission existingPermission = permissionService.getPermissionById(Permission.getId());
        if (existingPermission == null) {
            return ResponseEntity.notFound().build();
        }
        Permission permission = new Permission();
        BeanUtils.copyProperties(Permission,permission);
        Permission updatedPermission = permissionService.savePermission(permission);
        return ResponseEntity.ok(updatedPermission);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePermission(@PathVariable Long id) {
        Permission existingPermission = permissionService.getPermissionById(id);
        if (existingPermission == null) {
            return ResponseEntity.notFound().build();
        }
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}
