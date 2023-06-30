package com.epay.service.usermanagement.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author duantp
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerFunDto {
    private String permission;
    private String function;
}
