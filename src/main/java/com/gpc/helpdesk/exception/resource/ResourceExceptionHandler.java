package com.gpc.helpdesk.exception.resource;

import com.gpc.helpdesk.exception.standard.ObjectNotFoundException;
import com.gpc.helpdesk.exception.standard.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request){
        StandardError error = new StandardError();
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Object not found");
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }
}
