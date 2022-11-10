package com.mystays.APIGateway.constants;

public enum Errors {
    DEFAULT(1001, "Authentication Service unavailable"),
    HOTEL_SEARCH_SERVICE(1002, "Hotel Search Service unavailable"),
    ACCOUNT_SERVICE(1003, "Account Service unavailable"),
    GOOGLE_API(1004, "Google API unavailable");

    private int id;
    private String message;

    Errors(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}