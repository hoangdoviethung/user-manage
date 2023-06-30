package com.epay.service.usermanagement.config;

import com.epay.service.usermanagement.dto.response.AuthorizedResp;
import com.epay.service.usermanagement.entitys.*;
import com.epay.service.usermanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author duantp
 */

@Component
public class ConfigLoad {
    public static List<AuthorizedResp> authorizedRespList = new ArrayList<>();
    public static List<UserGroup> userGroups = new ArrayList<>();
    public static List<Role> roles = new ArrayList<>();
    public static List<Permission> permissions = new ArrayList<>();
    public static List<Function> functions = new ArrayList<>();
//    public static List<FunctionType> functionTypes = new ArrayList<>();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private FunctionRepository functionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

//    @Autowired
//    private FunctionTypeRepository functionTypeRepository;

    @Autowired
    public void init() {
        this.loadListAuthorized();
    }

    private void loadListAuthorized() {
        authorizedRespList = new ArrayList<>();
        List<Map<String, String>> data = userRepository.getListRole();
        for (Map<String, String> map : data) {
            AuthorizedResp auth = new AuthorizedResp();
            auth.setApi(map.get("api"));
            auth.setGroupName(map.get("groupName"));
            auth.setRoleName(map.get("roleName"));
            auth.setPermissionName(map.get("permissionName"));
            auth.setFunctionName(map.get("functionName"));
            authorizedRespList.add(auth);
        }
        userGroups = userGroupRepository.findAll();
        roles = roleRepository.findAll();
        permissions = permissionRepository.findAll();
        functions = functionRepository.findAll();
//        functionTypes = functionTypeRepository.findAll();
    }
}
