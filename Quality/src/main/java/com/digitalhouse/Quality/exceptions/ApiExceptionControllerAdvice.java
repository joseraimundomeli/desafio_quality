package com.digitalhouse.Quality.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){
        List<ValidationErroLog> validationErrorList = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            validationErrorList.add(new ValidationErroLog(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
                )
            );
        });
        return new ResponseEntity<List>(validationErrorList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity httpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request){
        return new ResponseEntity("Url incorreta!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity districtNotFoundException(DistrictNotFoundException ex, HttpServletRequest request){
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
