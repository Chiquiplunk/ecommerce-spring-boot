package com.davidlima.ecommerce.exception;

import com.davidlima.ecommerce.exception.response.ErrorResponse;
import com.davidlima.ecommerce.exception.response.FieldErrorMode;
import com.davidlima.ecommerce.exception.response.ValidationErrorResponse;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import javax.naming.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Description of ErrorHandler.
 *
 * @author David Lima
 */

@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleEntityNotFoundException(Exception ex){
    HttpStatus status = HttpStatus.NOT_FOUND;
    ErrorResponse error = ErrorResponse.builder()
        .code(status.value())
        .error(status.name())
        .message(ex.getMessage())
        .build();
    return ResponseEntity
        .status(status)
        .body(error);
  }

  @ExceptionHandler(EmailAlreadyTaken.class)
  public ResponseEntity<ErrorResponse> handleEmailAlreadyTaken(Exception ex){
    HttpStatus status = HttpStatus.CONFLICT;
    ErrorResponse error = ErrorResponse.builder()
        .code(status.value())
        .error(status.name())
        .message(ex.getMessage())
        .build();
    return ResponseEntity
        .status(status)
        .body(error);
  }

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<ErrorResponse> AuthenticationException(Exception ex){
    HttpStatus status = HttpStatus.UNAUTHORIZED;
    ErrorResponse error = ErrorResponse.builder()
        .code(status.value())
        .error(status.name())
        .message(ex.getMessage())
        .build();
    return ResponseEntity
        .status(status)
        .body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ValidationErrorResponse> MethodArgumentNotValidException(MethodArgumentNotValidException ex){

    HttpStatus status = HttpStatus.BAD_REQUEST;

    List<FieldErrorMode> errors = ex.getBindingResult().getAllErrors().stream().map(fieldError -> {
      FieldErrorMode fieldErrorMode = new FieldErrorMode();
      fieldErrorMode.setField(((FieldError)fieldError).getField());
      fieldErrorMode.setMessage(fieldError.getDefaultMessage());
      fieldErrorMode.setCode(fieldError.getCode());
      return fieldErrorMode;
    }).toList();

    ValidationErrorResponse response = new ValidationErrorResponse();
    response.setCode(status.value());
    response.setError(status.name());
    response.setErrors(errors);
    return ResponseEntity
        .status(status)
        .body(response);
  }

}
