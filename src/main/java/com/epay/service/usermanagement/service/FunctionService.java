package com.epay.service.usermanagement.service;


import com.epay.service.usermanagement.dto.FunctionDTO;
import com.epay.service.usermanagement.entitys.Function;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FunctionService {
    Page<Function> getAllFunctions(Pageable pageable);

    Function getFunctionById(Long id);

    Function saveFunction(Function function);

    void deleteFunction(Long id);
}
