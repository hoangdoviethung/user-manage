package com.epay.service.usermanagement.service.serviceImpl;

import com.epay.service.usermanagement.dto.UserGroupDTO;
import com.epay.service.usermanagement.entitys.UserGroup;
import com.epay.service.usermanagement.repository.UserGroupRepository;
import com.epay.service.usermanagement.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserGroupServiceImplement implements UserGroupService {

    private final UserGroupRepository userGroupRepository;

    @Autowired
    public UserGroupServiceImplement(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public Page<UserGroupDTO> getAllUserGroups(Pageable pageable) {
        return userGroupRepository.getAllUserGroup(pageable);
    }

    @Override
    public UserGroupDTO getUserGroupById(Long id) {
        return userGroupRepository.getUserGroupById(id);
    }

    @Override
    public UserGroup saveUserGroup(UserGroup userGroup) {
        return userGroupRepository.save(userGroup);
    }

    @Override
    public void deleteUserGroup(Long id) {
        userGroupRepository.deleteById(id);
    }
}
