package com.epay.service.usermanagement.service;

import com.epay.service.usermanagement.dto.UserGroupDTO;
import com.epay.service.usermanagement.entitys.UserGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserGroupService {
    Page<UserGroupDTO> getAllUserGroups(Pageable pageable);

    UserGroupDTO getUserGroupById(Long id);

    UserGroup saveUserGroup(UserGroup userGroup);

    void deleteUserGroup(Long id);
}
