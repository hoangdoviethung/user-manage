package com.epay.service.usermanagement.service;

import com.epay.service.usermanagement.dto.UserDTO;
import com.epay.service.usermanagement.dto.request.UpdateGroupUserReq;
import com.epay.service.usermanagement.dto.response.AccessInformation;
import com.epay.service.usermanagement.dto.response.ErrorMessage;
import com.epay.service.usermanagement.entitys.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);

    User getUserById(Long id);

    User saveUser(User user);

    void deleteUser(Long id);

    UserDTO getByUserName(HttpServletRequest request);

    AccessInformation getAccessInformation(HttpServletRequest request);

    ErrorMessage update(UpdateGroupUserReq data);
}
