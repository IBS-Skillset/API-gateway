package com.mystays.APIGateway.util;

import com.mystays.APIGateway.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {
    public static ResponseEntity<ErrorResponse> build(HttpStatus status, String errorMessage) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(status.getReasonPhrase());
        errorResponse.setErrorCode(status.value());
        errorResponse.setErrorText(errorMessage);
        return new ResponseEntity<>(errorResponse, status);
    }
    public static ResponseEntity<ErrorResponse> build(HttpStatus status, String errorMessage, String errorCode) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(status.getReasonPhrase());
        errorResponse.setErrorCode(Integer.parseInt(errorCode));
        errorResponse.setErrorText(errorMessage);
        return new ResponseEntity<>(errorResponse, status);
    }
}