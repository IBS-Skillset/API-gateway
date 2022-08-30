package com.mystays.APIGateway.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
    @GetMapping("/authenticateFallback")
    public String defaultMessage()
    {
        return "There were some error in connecting Authorization server. Please try again later.";
    }

    @GetMapping("/hotelSearchServiceFallback")
    public String hotelSearchServiceFallback()
    {
        return "There were some error in connecting Hotel Search Service. Please try again later.";
    }
}
