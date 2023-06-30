package com.epay.service.usermanagement.dto;

import com.epay.service.usermanagement.entitys.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    private String fullName;

    private String username;

    private UserGroupDTO userGroup;

    public UserDTO(Long id, String fullName, String username) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
    }

    public UserDTO(Long id, String fullName, String username, UserGroup userGroup) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.userGroup = new UserGroupDTO();
        RoleDTO roleDTO = new RoleDTO();
        this.userGroup.setId(userGroup.getId());
//        this.userGroup.setGroupName(userGroup.getGroupName());
//        this.userGroup.setRoleId(userGroup.getRole().getId());
//        roleDTO.setId(userGroup.getRole().getId());
//        roleDTO.setRoleName(userGroup.getRole().getRoleName());
//        this.userGroup.setRole(roleDTO);
    }
}
