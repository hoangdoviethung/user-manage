package com.epay.service.usermanagement.repository;

import com.epay.service.usermanagement.dto.UserGroupDTO;
import com.epay.service.usermanagement.entitys.UserGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
    @Query(value = "SELECT NEW com.epay.service.usermanagement.dto.UserGroupDTO(u.id, u.groupName) FROM UserGroup u")
    Page<UserGroupDTO> getAllUserGroup(Pageable pageable);

    @Query(value = "SELECT NEW com.epay.service.usermanagement.dto.UserGroupDTO(u.id, u.groupName) FROM UserGroup u WHERE u.id = ?1")
    UserGroupDTO getUserGroupById(Long id);
}
