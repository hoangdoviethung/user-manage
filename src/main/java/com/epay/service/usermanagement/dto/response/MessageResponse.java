package com.epay.service.usermanagement.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author duantp
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageResponse {
    private int status;
    private String message;

}
