package com.epay.service.usermanagement.repository;

import com.epay.service.usermanagement.dto.FunctionDTO;
import com.epay.service.usermanagement.entitys.Function;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionRepository extends JpaRepository<Function, Long> {
    @Query("SELECT NEW com.epay.service.usermanagement.dto.FunctionDTO(f.id, f.functionName, f.api, f.description ) FROM Function f")
    Page<FunctionDTO> getAllFunction(Pageable pageable);

    @Query("SELECT NEW com.epay.service.usermanagement.dto.FunctionDTO(f.id, f.functionName, f.api, f.description ) FROM Function f WHERE f.id = ?1")
    FunctionDTO getFunctionById(Long id);

    @Query("SELECT NEW com.epay.service.usermanagement.dto.FunctionDTO(f.id, f.functionName, f.api, f.description ) FROM Function f")
    FunctionDTO getFunctionByPermissionId(Long id);
}
