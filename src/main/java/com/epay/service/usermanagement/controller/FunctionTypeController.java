//package com.epay.service.usermanagement.controller;
//
//import com.epay.service.usermanagement.dto.FunctionTypeDTO;
//import com.epay.service.usermanagement.dto.UserGroupDTO;
//import com.epay.service.usermanagement.entitys.FunctionType;
//import com.epay.service.usermanagement.service.FunctionTypeService;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/function-types")
//public class FunctionTypeController {
//
//    @Autowired
//    private FunctionTypeService functionTypeService;
//
//    @PostMapping("/create")
//    public ResponseEntity<FunctionType> createFunctionType(@RequestBody FunctionType functionType) {
//        FunctionType createdFunctionType = functionTypeService.createFunctionType(functionType);
//        return new ResponseEntity<>(createdFunctionType, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get-by-id/{id}")
//    public ResponseEntity<FunctionType> getFunctionTypeById(@PathVariable Long id) {
//        FunctionType functionType = functionTypeService.getFunctionTypeById(id);
//        if (functionType == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(functionType, HttpStatus.OK);
//    }
//
//    @GetMapping("/get-all")
//    public ResponseEntity<List<FunctionType>> getAllFunctionTypes() {
//        List<FunctionType> functionTypes = functionTypeService.getAllFunctionTypes();
//        return new ResponseEntity<>(functionTypes, HttpStatus.OK);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<FunctionType> updateFunctionType(@RequestBody FunctionTypeDTO functionTypeDTO) {
//        FunctionType existingFunctionType = functionTypeService.getFunctionTypeById(functionTypeDTO.getId());
//        if (existingFunctionType == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        FunctionType functionType = new FunctionType();
//        BeanUtils.copyProperties(functionTypeDTO, functionType);
//        FunctionType updatedFunctionType = functionTypeService.updateFunctionType(functionType);
//        return new ResponseEntity<>(updatedFunctionType, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteFunctionType(@PathVariable Long id) {
//        FunctionType existingFunctionType = functionTypeService.getFunctionTypeById(id);
//        if (existingFunctionType == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        functionTypeService.deleteFunctionType(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//
////    @GetMapping("/get-case-menu")
////    public ResponseEntity<List<FunctionTypeDTO>> getCaseMenu() {
////        List<FunctionTypeDTO> existingFunctionType = functionTypeService.getCaseMenu();
////        if (existingFunctionType == null) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////        return new ResponseEntity<>(existingFunctionType,HttpStatus.OK);
////    }
//
//
//}
