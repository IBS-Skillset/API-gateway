package com.mystays.APIGateway.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
    @GetMapping("/authenticateFallback")
    public ResponseEntity<String> defaultMessage()
    {
        ResponseEntity e = new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        return e;
    }

    @GetMapping("/hotelSearchServiceFallback")
    public ResponseEntity<String> hotelSearchServiceFallback()
    {
        ResponseEntity r = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return r;
    }
}
