package com.TW.mobile_app_ws.exception;

import com.TW.mobile_app_ws.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice      //this annotation is crucial for listening exceptions
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
        String errorMessageDesc = ex.getLocalizedMessage();
        if(errorMessageDesc == null) errorMessageDesc = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDesc);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleSpecificExceptions(Exception ex, WebRequest request){
        String errorMessageDesc = ex.getLocalizedMessage();
        if(errorMessageDesc == null) errorMessageDesc = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDesc);

        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
