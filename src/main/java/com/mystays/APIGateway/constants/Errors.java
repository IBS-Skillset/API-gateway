package com.mystays.APIGateway.constants;

public enum Errors {
    DEFAULT(1000, "Authentication Service unavailable"),
    HOTEL_SEARCH_SERVICE(1002, "Hotel Search Service unavailable"),
    ACCOUNT_SERVICE(1003, "Account Service unavailable"),
    GOOGLE_API(1004, "Google API unavailable");

    private final int id;
    private final String message;

    Errors(int id, String message) {
        this.id = id;
        this.message = message;
    }

}