package com.epay.service.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionDTO implements Serializable {

    private Long id;

    private String functionName;

    private String api;

    private String description;

    private int status;

    public FunctionDTO(Long id, String functionName, String api, String description) {
        this.id = id;
        this.functionName = functionName;
        this.api = api;
        this.description = description;
    }
}
