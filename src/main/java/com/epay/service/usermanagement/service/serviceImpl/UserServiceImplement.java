package com.epay.service.usermanagement.service.serviceImpl;

import com.epay.service.usermanagement.config.ConfigLoad;
import com.epay.service.usermanagement.dto.*;
import com.epay.service.usermanagement.dto.request.UpdateGroupUserReq;
import com.epay.service.usermanagement.dto.response.AccessInformation;
import com.epay.service.usermanagement.dto.response.ErrorMessage;
import com.epay.service.usermanagement.entitys.*;
import com.epay.service.usermanagement.repository.UserGroupRepository;
import com.epay.service.usermanagement.repository.UserRepository;
import com.epay.service.usermanagement.security.jwt.AuthTokenFilter;
import com.epay.service.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthTokenFilter authTokenFilter;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        Page<User> list = userRepository.findAll(pageable);
        return list;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getByUserName(HttpServletRequest request) {
        Optional<User> userOp = authTokenFilter.getUserLogin(request);
        if (userOp.isPresent()) {
            UserDTO userDTO = new UserDTO(userOp.get().getId(), userOp.get().getFullName(), userOp.get().getUsername());
            return userDTO;
        }
        return null;
    }

    @Override
    public AccessInformation getAccessInformation(HttpServletRequest request) {
        Optional<User> userOp = authTokenFilter.getUserLogin(request);
        if (userOp.isPresent()) {
            return this.init(userOp.get());
        }
        return null;
    }

    public AccessInformation init(User user) {
        AccessInformation accessInformation = new AccessInformation();
        Set<Long> groupIds = new HashSet<>();
        Set<Long> roleIds = new HashSet<>();
        Set<Long> permissionIds = new HashSet<>();
        Set<Long> functionIds = new HashSet<>();

        if (user.getGroup() != null) {
            groupIds.add(user.getGroup().getId());
            if (user.getGroup().getRole() != null) {
                roleIds.add(user.getGroup().getRole().getId());
            }
            for (Permission p : user.getGroup().getRole().getPermissions()) {
                permissionIds.add(p.getId());
                for (Function f : p.getFunctions()) {
                    functionIds.add(f.getId());
                }
            }
        }

        List<UserGroupDTO> groupDto = new ArrayList<>();
        for (UserGroup u : ConfigLoad.userGroups) {
            UserGroupDTO dto = new UserGroupDTO();
            dto.setId(u.getId());
            dto.setGroupName(u.getGroupName());
            dto.setStatus(groupIds.contains(u.getId()) ? 1 : 0);
            groupDto.add(dto);
        }

        List<RoleDTO> roleDto = new ArrayList<>();
        for (Role r : ConfigLoad.roles) {
            RoleDTO dto = new RoleDTO();
            dto.setId(r.getId());
            dto.setRoleName(r.getRoleName());
            dto.setStatus(roleIds.contains(r.getId()) ? 1 : 0);
            roleDto.add(dto);
        }

        List<PermissionDTO> permissionDto = new ArrayList<>();
        for (Permission p : ConfigLoad.permissions) {
            PermissionDTO dto = new PermissionDTO();
            dto.setPermissionName(p.getPermissionName());
            dto.setId(p.getId());
            dto.setStatus(permissionIds.contains(p.getId()) ? 1 : 0);
            dto.setFunctionType(p.getFunctionType());
            permissionDto.add(dto);
        }

        List<FunctionDTO> functionDto = new ArrayList<>();
        for (Function f : ConfigLoad.functions) {
            FunctionDTO dto = new FunctionDTO();
            dto.setFunctionName(f.getFunctionName());
            dto.setDescription(f.getDescription());
            dto.setApi(f.getApi());
            dto.setId(f.getId());
            dto.setStatus(functionIds.contains(f.getId()) ? 1 : 0);
            functionDto.add(dto);
        }

        accessInformation.setId(user.getId());
        accessInformation.setUsername(user.getUsername());
        accessInformation.setFullName(user.getFullName());
        accessInformation.setFunctions(functionDto);
        accessInformation.setPermissions(permissionDto);
        accessInformation.setUserGroups(groupDto);
        accessInformation.setRoles(roleDto);
        return accessInformation;
    }

    @Override
    public ErrorMessage update(UpdateGroupUserReq data) {
        try {
            Optional<User> userOp = userRepository.findById(data.getUserId());
            if (userOp.isPresent()) {
                Optional<UserGroup> userGroup = userGroupRepository.findById(data.getGroupId());
                if (userGroup.isPresent()) {
                    userOp.get().setGroup(userGroup.get());
                } else {
                    return new ErrorMessage("-1", "Không tìm thấy userGroup");
                }
            }
        } catch (Exception e) {
            return new ErrorMessage("-1", "Có lỗi xảy ra");
        }
        return new ErrorMessage("0", "Thành công");
    }
}
