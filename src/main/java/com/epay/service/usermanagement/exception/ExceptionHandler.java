//package com.epay.service.usermanagement.exception;
//
//import com.epay.service.usermanagement.dto.response.ErrorMessage;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//@ControllerAdvice
//public class ExceptionHandler {
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @org.springframework.web.bind.annotation.ExceptionHandler
//    @ResponseBody
//    public ResponseEntity<ErrorMessage> showCustomMessage(Exception e){
//        ErrorMessage errorMessage = new ErrorMessage();
//        if (e instanceof AccessDeniedException){
//            errorMessage.setErrorMessage("Không có quyền truy cập api");
//            errorMessage.setErrorCode(String.valueOf(HttpStatus.FORBIDDEN.value()));
//            return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
//        }
//        logger.warn("Invalid request message!\n{}",e.getMessage());
//        errorMessage.setErrorMessage(e.getMessage());
//        errorMessage.setErrorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
//        return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
//    }
//}