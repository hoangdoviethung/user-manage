package com.epay.service.usermanagement.service;

import com.epay.service.usermanagement.dto.RoleDTO;
import com.epay.service.usermanagement.entitys.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {
    Page<Role> getAllRoles(Pageable pageable);

    Role getRoleById(Long id);

    Role saveRole(Role role);

    void deleteRole(Long id);
}
