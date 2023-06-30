package com.epay.service.usermanagement.service;

import com.epay.service.usermanagement.dto.PermissionDTO;
import com.epay.service.usermanagement.entitys.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PermissionService {
    Page<Permission> getAllPermissions(Pageable pageable);

    Permission getPermissionById(Long id);

    Permission savePermission(Permission permission);

    void deletePermission(Long id);
}
