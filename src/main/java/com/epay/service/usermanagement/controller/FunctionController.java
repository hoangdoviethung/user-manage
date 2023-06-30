package com.epay.service.usermanagement.controller;

import com.epay.service.usermanagement.entitys.Function;
import com.epay.service.usermanagement.service.FunctionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/functions")
@CrossOrigin("*")
public class FunctionController {

    private final FunctionService functionService;

    @Autowired
    public FunctionController(FunctionService functionService) {
        this.functionService = functionService;
    }

    @GetMapping("get-all")
    @PreAuthorize(value = "@authorizedService.preAuth('/functions')")
    public ResponseEntity<Page<Function>> getAllFunctions(@PageableDefault Pageable pageable) {
        Page<Function> functions = functionService.getAllFunctions(pageable);
        return ResponseEntity.ok().body(functions);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Function> getFunctionById(@PathVariable Long id) {
        Function function = functionService.getFunctionById(id);
        if (function == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(function);
    }

    @PostMapping("/create")
    public ResponseEntity<Function> createFunction(@RequestBody Function function) {
        Function createdFunction = functionService.saveFunction(function);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFunction);
    }

    @PutMapping("/update")
    public ResponseEntity<Function> updateFunction(@RequestBody Function Function) {
        Function existingFunction = functionService.getFunctionById(Function.getId());
        if (existingFunction == null) {
            return ResponseEntity.notFound().build();
        }
        Function function = new Function();
        BeanUtils.copyProperties(Function,function);
        Function updatedFunction = functionService.saveFunction(function);
        return ResponseEntity.ok(updatedFunction);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFunction(@PathVariable Long id) {
        Function existingFunction = functionService.getFunctionById(id);
        if (existingFunction == null) {
            return ResponseEntity.notFound().build();
        }
        functionService.deleteFunction(id);
        return ResponseEntity.noContent().build();
    }
}
