package com.mystays.APIGateway.controller;
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
        return ResponseEntityBuilder.build(HttpStatus.OK, "Authenticate failure", "1000");
    }

    @GetMapping("/hotelSearchServiceFallback")
    public ResponseEntity<ErrorResponse> hotelSearchServiceFallback()
    {
        return ResponseEntityBuilder.build(HttpStatus.OK, "Hotel Search Service unavailable", "1001");
    }

    @GetMapping("/accountServiceFallback")
    public ResponseEntity<ErrorResponse> accountServiceFallback()
    {
        return ResponseEntityBuilder.build(HttpStatus.OK, "Account Service unavailable", "1002");
    }

    @GetMapping("/googleApiFallback")
    public ResponseEntity<ErrorResponse> googleApiFallback()
    {
        return ResponseEntityBuilder.build(HttpStatus.OK, "Google API unavailable", "1003");
    }
}
