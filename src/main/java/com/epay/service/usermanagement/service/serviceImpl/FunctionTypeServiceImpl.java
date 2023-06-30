//package com.epay.service.usermanagement.service.serviceImpl;
//
//import com.epay.service.usermanagement.dto.*;
//import com.epay.service.usermanagement.entitys.*;
//import com.epay.service.usermanagement.repository.FunctionTypeRepository;
//import com.epay.service.usermanagement.repository.PermissionRepository;
//import com.epay.service.usermanagement.repository.UserGroupRepository;
//import com.epay.service.usermanagement.service.FunctionTypeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class FunctionTypeServiceImpl implements FunctionTypeService {
//
//    @Autowired
//    private FunctionTypeRepository functionTypeRepository;
//    @Autowired
//    private UserGroupRepository userGroupRepository;
//
//
//    @Override
//    public FunctionType createFunctionType(FunctionType functionType) {
//        return functionTypeRepository.save(functionType);
//    }
//
//    @Override
//    public FunctionType getFunctionTypeById(Long id) {
//        return functionTypeRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public List<FunctionType> getAllFunctionTypes() {
//        return functionTypeRepository.findAll();
//    }
//
//    @Override
//    public FunctionType updateFunctionType(FunctionType functionType) {
//        return functionTypeRepository.save(functionType);
//    }
//
//    @Override
//    public void deleteFunctionType(Long id) {
//        functionTypeRepository.deleteById(id);
//    }
//
////    @Override
////    public List<UserGroupDTO> getCaseMenu() {
////        return getCase();
////    }
//
//
//    public List<UserGroupDTO> getCase() {
//        List<UserGroup> userGroups = userGroupRepository.findAll();
//        List<UserGroupDTO> userGroupDTOS = new ArrayList<>();
//
////        for (UserGroup u: userGroups){
////            UserGroupDTO userGroupDTO = new UserGroupDTO();
////            RoleDTO roleDTO = new RoleDTO();
////            if (u.getRole() != null){
////                List<PermissionDTO> permissionDTO = new ArrayList<>();
////                if (u.getRole().getPermissions() != null){
////                    for (Permission p : u.getRole().getPermissions()) {
////                        List<FunctionDTO> functionDTO = new ArrayList<>();
////                        if (p.getFunctions() != null) {
////                            for (Function function : p.getFunctions()) {
////                                FunctionDTO fn = new FunctionDTO();
////                                fn.setId(function.getId());
////                                fn.setApi(function.getApi());
////                                fn.setFunctionName(function.getFunctionName());
////                                fn.setDescription(function.getDescription());
////                                functionDTO.add(fn);
////                            }
////                            PermissionDTO permission = new PermissionDTO();
////                            permission.setPermissionName(p.getPermissionName());
////                            permission.setId(p.getId());
////                            permission.setFunctions(functionDTO);
////                            permission.setRoleId(u.getRole().getId());
////                            permissionDTO.add(permission);
////                        }
////                    }
////                }
////                roleDTO.setId(u.getRole().getId());
////                roleDTO.setRoleName(u.getRole().getRoleName());
////                roleDTO.setPermissions(permissionDTO);
////                userGroupDTO.setRoleId(u.getRole().getId());
////            }
////            userGroupDTO.setId(u.getId());
////            userGroupDTO.setGroupName(u.getGroupName());
////            userGroupDTO.setRole(roleDTO);
////            userGroupDTOS.add(userGroupDTO);
////        }
//        return userGroupDTOS;
//    }
//
//
//}
