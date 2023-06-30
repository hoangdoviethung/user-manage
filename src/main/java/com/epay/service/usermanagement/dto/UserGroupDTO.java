package com.epay.service.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserGroupDTO implements Serializable {

    private Long id;

    private String groupName;

    private int status;

    public UserGroupDTO(Long id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    //    private Long roleId;

//    public UserGroupDTO(Long id, String groupName, Long roleId) {
//        this.id = id;
//        this.groupName = groupName;
//        this.roleId = roleId;
//    }
//
//    private RoleDTO role;
}
