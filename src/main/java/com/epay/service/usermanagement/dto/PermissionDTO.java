package com.epay.service.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PermissionDTO implements Serializable {

    private Long id;

    private String permissionName;

    private int status;

    private String functionType;

    public PermissionDTO(Long id, String permissionName) {
        this.id = id;
        this.permissionName = permissionName;
    }

    //    private Long roleId;

//    public PermissionDTO(Long id, String permissionName, Long roleId) {
//        this.id = id;
//        this.permissionName = permissionName;
//        this.roleId = roleId;
//    }
//
//    private List<FunctionDTO> functions;
}
