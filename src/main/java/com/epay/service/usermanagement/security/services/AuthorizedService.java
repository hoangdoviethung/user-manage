
package com.epay.service.usermanagement.security.services;

import com.epay.service.usermanagement.config.ConfigLoad;
import com.epay.service.usermanagement.dto.response.AuthorizedResp;
import com.epay.service.usermanagement.entitys.User;
import com.epay.service.usermanagement.entitys.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "authorizedService")
public class AuthorizedService {
    Logger logger = LoggerFactory.getLogger(AuthorizedService.class);

    @Autowired
    private HttpSession session;

    public boolean preAuth(String path) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetailsImpl userDetails = (UserDetailsImpl) securityContext.getAuthentication().getPrincipal();

        List<AuthorizedResp> authorizedResps = ConfigLoad.authorizedRespList
                .stream()
                .filter(c -> c.getApi().equals(path))
                .collect(Collectors.toList());

        if (authorizedResps == null || authorizedResps.size() == 0) return true;

        String groupUsers = userDetails.getAuthorities().stream().map(x -> x.getAuthority()).findAny().orElse(null);

        if (groupUsers != null) {
            List<AuthorizedResp> authorized = authorizedResps
                    .stream()
                    .filter(c -> c.getGroupName().equals(groupUsers))
                    .collect(Collectors.toList());
            if (authorized.size() > 0) {
                return true;
            }
        }
        return false;
    }

    public String getCurrentUser() {
        User user = this.currentUser();
        if (user == null) {
            return "epay.vn";
        }
        return user.getUsername();
    }

    public String getLoginName() {
        User user = this.currentUser();
        if (user == null) {
            return "No session";
        }
        return user.getUsername();
    }

    public Long getLoginUserID() {
        try {
            User user = this.currentUser();
            return user.getId();
        } catch (Exception ex) {
            logger.error("get IdUser fail: {}", ex.getMessage());
            return null;
        }
    }

    public User currentUser() {
        try {
            User currentUser = (User) session.getAttribute("currentUser");
            return currentUser;
        } catch (Exception ex) {
            logger.error("get currentUser fail: {}", ex.getMessage());
            return null;
        }

    }
}
