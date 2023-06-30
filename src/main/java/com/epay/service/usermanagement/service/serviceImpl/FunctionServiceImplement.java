package com.epay.service.usermanagement.service.serviceImpl;

import com.epay.service.usermanagement.dto.FunctionDTO;
import com.epay.service.usermanagement.entitys.Function;
import com.epay.service.usermanagement.repository.FunctionRepository;
import com.epay.service.usermanagement.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FunctionServiceImplement implements FunctionService {

    private final FunctionRepository functionRepository;

    @Autowired
    public FunctionServiceImplement(FunctionRepository functionRepository) {
        this.functionRepository = functionRepository;
    }

    @Override
    public Page<Function> getAllFunctions(Pageable pageable) {
        return functionRepository.findAll(pageable);
    }

    @Override
    public Function getFunctionById(Long id) {
        return functionRepository.findById(id).get();
    }

    @Override
    public Function saveFunction(Function function) {
        return functionRepository.save(function);
    }

    @Override
    public void deleteFunction(Long id) {
        functionRepository.deleteById(id);
    }
}
