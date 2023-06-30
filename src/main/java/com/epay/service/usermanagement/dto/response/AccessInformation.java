package com.epay.service.usermanagement.dto.response;

import com.epay.service.usermanagement.dto.FunctionDTO;
import com.epay.service.usermanagement.dto.PermissionDTO;
import com.epay.service.usermanagement.dto.RoleDTO;
import com.epay.service.usermanagement.dto.UserGroupDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccessInformation {
    private Long id;

    private String fullName;

    private String username;

    private List<UserGroupDTO> userGroups;

    private List<RoleDTO> roles;

    private List<PermissionDTO> permissions;

    private List<FunctionDTO> functions;
}
