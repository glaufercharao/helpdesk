package com.gpc.helpdesk.exception.resource;

import com.gpc.helpdesk.exception.standard.DataIntegrityViolationException;
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
        StandardError error = buildError(ex,HttpStatus.NOT_FOUND.value(),
                "Objeto não encontrado!", request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request){
        StandardError error = buildError(ex,HttpStatus.BAD_REQUEST.value(),
                "Integrity violation", request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

    private StandardError buildError(Exception ex, Integer status, String errorTitle, String requestPath){
        StandardError error = new StandardError();
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatus(status);
        error.setError(errorTitle);
        error.setMessage(ex.getMessage());
        error.setPath(requestPath);
        return error;
    }

}
