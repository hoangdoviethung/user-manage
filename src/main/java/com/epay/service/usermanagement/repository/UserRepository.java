package com.epay.service.usermanagement.repository;

import com.epay.service.usermanagement.dto.UserDTO;
import com.epay.service.usermanagement.entitys.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    @Query(value = "select f.api,ug.group_name groupName,r.role_name roleName, p.permission_name permissionName,f.function_name functionName\n" +
            "             from tbl_user_group ug \n" +
            "             INNER JOIN tbl_role r ON ug.role_id = r.id\n" +
            "             LEFT JOIN tbl_permission p ON r.id = p.role_id\n" +
            "             INNER JOIN tbl_functions_permissions fp on p.id = fp.permission_id\n" +
            "             LEFT JOIN tbl_function f on  fp.function_id = f.id", nativeQuery = true)
    List<Map<String, String>> getListRole();
//
    @Query(value = "select ug.id groupId, ug.group_Name groupName, r.id roleId, r.role_name roleName, p.id permissionId, p.permission_name permissionName,f.id functionId, f.function_name functionName, f.description\n" +
            "from tbl_user u\n" +
            "left join tbl_user_group  ug on u.group_id = ug.id\n" +
            "left join tbl_role r ON ug.role_id = r.id\n" +
            "left join tbl_permission p on p.role_id = r.id\n" +
            "left join tbl_functions_permissions fp on p.id = fp.permission_id\n" +
            "right join tbl_function f on fp.function_id = f.id\n" +
            "where u.username = :username", nativeQuery = true)
    List<Map<String, Object>> getUserAccessInformation(String username);

    @Query(value = "SELECT NEW com.epay.service.usermanagement.dto.UserDTO(u.id, u.username, u.fullName, u.group) FROM User u")
    Page<UserDTO> getAllUser(Pageable pageable);

    @Query(value = "SELECT NEW com.epay.service.usermanagement.dto.UserDTO(u.id, u.username, u.fullName) FROM User u WHERE u.id = ?1")
    UserDTO getUserById(Long id);

}

