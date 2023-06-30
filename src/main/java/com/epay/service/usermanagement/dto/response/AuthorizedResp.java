package com.epay.service.usermanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author duantp
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AuthorizedResp {
    private String api;
    private String groupName;
    private String roleName;
    private String permissionName;
    private String functionName;
}
