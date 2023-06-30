package com.epay.service.usermanagement.service.serviceImpl;

import com.epay.service.usermanagement.dto.FunctionDTO;
import com.epay.service.usermanagement.dto.PermissionDTO;
import com.epay.service.usermanagement.entitys.Permission;
import com.epay.service.usermanagement.repository.PermissionRepository;
import com.epay.service.usermanagement.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImplement implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionServiceImplement(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Page<Permission> getAllPermissions(Pageable pageable) {
        return permissionRepository.findAll(pageable);
    }

    @Override
    public Permission getPermissionById(Long id) {
        return permissionRepository.findById(id).get();
    }

    @Override
    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public void deletePermission(Long id) {
        permissionRepository.deleteById(id);
    }
}
