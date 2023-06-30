package com.epay.service.usermanagement.repository;

import com.epay.service.usermanagement.dto.RoleDTO;
import com.epay.service.usermanagement.entitys.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "SELECT NEW com.epay.service.usermanagement.dto.RoleDTO(r.id, r.roleName) FROM Role r")
    Page<RoleDTO> getAllRole(Pageable pageable);

    @Query(value = "SELECT NEW com.epay.service.usermanagement.dto.RoleDTO(r.id, r.roleName) FROM Role r WHERE r.id = ?1")
    RoleDTO getRoleById(Long id);
}
