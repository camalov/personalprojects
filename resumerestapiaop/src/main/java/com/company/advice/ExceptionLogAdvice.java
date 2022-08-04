package com.company.advice;

import com.company.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice()
public class ExceptionLogAdvice {

    // default singleton with adviceController
    private static final Logger LOG = Logger.getLogger(ExceptionLogAdvice.class.getName());

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public void handleUserAlreadyExistException(Exception ex) {
        System.out.println("ExceptionLogAdvice is running");
        LOG.log(Level.FINE, "sadasdasdasd", "test");
        System.out.println(LOG);
        /*
        ResponseDTO internalServerError = ResponseDTO.of(ex, 500, ex.getMessage());
        UserRestLoggingAspect userRestLoggingAspect = new UserRestLoggingAspect();
*/
//        return ResponseEntity.internalServerError().body(ResponseDTO.of(LOG, 500, "Internal Server Error"));
    }

}