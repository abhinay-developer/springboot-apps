package com.abhi.modelmapper.exception;

import com.abhi.modelmapper.dto.HttpErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerIdNotFoundException.class)
   public ResponseEntity<HttpErrorResponse> handleCustomerIdNotFoundException(CustomerIdNotFoundException ex){
       HttpErrorResponse httpErrorResponse=new HttpErrorResponse();
       httpErrorResponse.setDate(new Date());
       httpErrorResponse.setMessage(ex.getMessage());
       httpErrorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
       httpErrorResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(httpErrorResponse);
   }

}
