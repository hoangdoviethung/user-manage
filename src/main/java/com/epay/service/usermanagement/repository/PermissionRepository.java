package com.epay.service.usermanagement.repository;

import com.epay.service.usermanagement.dto.PermissionDTO;
import com.epay.service.usermanagement.entitys.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    @Query(value = "SELECT NEW com.epay.service.usermanagement.dto.PermissionDTO(p.id, p.permissionName) FROM Permission p")
    Page<PermissionDTO> getAllPermission(Pageable pageable);

    @Query(value = "SELECT NEW com.epay.service.usermanagement.dto.PermissionDTO(p.id, p.permissionName) FROM Permission p WHERE p.id = ?1")
    PermissionDTO getPermissionById(Long id);

    @Query(value = "SELECT NEW com.epay.service.usermanagement.dto.PermissionDTO(p.id, p.permissionName) FROM Permission p ")
    PermissionDTO getPermissionByFunctionTypeId(Long id);
}
