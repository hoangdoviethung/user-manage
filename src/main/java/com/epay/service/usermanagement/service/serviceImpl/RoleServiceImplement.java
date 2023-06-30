package com.epay.service.usermanagement.service.serviceImpl;

import com.epay.service.usermanagement.dto.RoleDTO;
import com.epay.service.usermanagement.entitys.Role;
import com.epay.service.usermanagement.repository.RoleRepository;
import com.epay.service.usermanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplement implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImplement(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Page<Role> getAllRoles(Pageable pageable) {
        return roleRepository.findAll(pageable);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
