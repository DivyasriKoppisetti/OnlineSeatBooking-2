package com.OSB.Exception;



import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
//@ControllerAdvice is a specialization of the @Component annotation 
//which allows to handle exceptions across the whole application in one global handling component
//It can be viewed as an interceptor of exceptions thrown by methods 
//annotated with @RequestMapping and similar.
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  // Annotation for handling exceptions in specific handler classes and/or handler
  // methods.
  public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
      ExceptionResponse response = new ExceptionResponse();
      response.setErrorCode("NOT_FOUND");
      response.setErrorMessage(ex.getMessage());
      response.setTimestamp(LocalDateTime.now());
      return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
  }
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
          HttpHeaders headers, HttpStatus status, WebRequest request) {
      Map<String, String> errors = new HashMap<>();
      ex.getBindingResult().getAllErrors().forEach((error) -> {
          String fieldName = ((FieldError) error).getField();
          String message = error.getDefaultMessage();
          errors.put(fieldName, message);
      });
      return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
  }
}