package com.epay.service.usermanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author duantp
 */

@AllArgsConstructor
@Data
public class JwtResponse {
    private String token;
    private Long expiredTime;
}
