package com.example.Spring3_Security6.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {

   /* @Autowired
    private ErrorDto errorDto;*/

    //@ExceptionHandler(MissingServletRequestParameterException.class)
    public ProblemDetail handleMissingServletRequestParameterException(MissingServletRequestParameterException ex) {
        //this is one way to handle exception
       /* errorDto.setStatus("FAIL");
        errorDto.setErrorMessage(ex.getMessage());
        errorDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.name());
        return errorDto;*/
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

}
