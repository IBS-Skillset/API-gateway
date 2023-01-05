package com.mystays.APIGateway.controller;
import com.mystays.APIGateway.constants.Errors;
import com.mystays.APIGateway.model.ErrorResponse;
import com.mystays.APIGateway.util.ResponseEntityBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
    @GetMapping("/authenticateFallback")
    public ResponseEntity<ErrorResponse> defaultMessage()
    {
        return ResponseEntityBuilder.build(HttpStatus.OK, String.valueOf(Errors.DEFAULT.getMessage()));
    }

    @GetMapping("/hotelSearchServiceFallback")
    public ResponseEntity<ErrorResponse> hotelSearchServiceFallback()
    {
        return ResponseEntityBuilder.build(HttpStatus.OK, String.valueOf(Errors.HOTEL_SEARCH_SERVICE.getMessage()));
    }

    @GetMapping("/accountServiceFallback")
    public ResponseEntity<ErrorResponse> accountServiceFallback()
    {
        return ResponseEntityBuilder.build(HttpStatus.OK, String.valueOf(Errors.ACCOUNT_SERVICE.getMessage()));
    }

    @GetMapping("/googleApiFallback")
    public ResponseEntity<ErrorResponse> googleApiFallback()
    {
        return ResponseEntityBuilder.build(HttpStatus.OK, String.valueOf(Errors.GOOGLE_API.getMessage()));
    }

    @GetMapping("/hotelBookServiceFallback")
    public String hotelBookServiceFallback()
    {
        return "There were some error in connecting Hotel Search Service. Please try again later.";
    }

    @GetMapping("/hotelBookQueryFallback")
    public String hotelBookQueryFallback()
    {
        return "There were some error in connecting Hotel Book Query. Please try again later.";
    }

    @GetMapping("/hotelBookCmdFallback")
    public String hotelBookCmdFallback()
    {
        return "There were some error in connecting Hotel Book Command. Please try again later.";
    }
}
