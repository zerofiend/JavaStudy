package com.aop.selfexception;

public class MoneyException extends RuntimeException {
    public MoneyException() {

    }

    public MoneyException(String message) {
        super(message);
    }
}
