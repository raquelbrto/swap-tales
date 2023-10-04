package com.imd.web.swaptales.util.exception;

public class BusinessRuleException extends Exception {
    public BusinessRuleException() {
        super("Business rule violation occurred.");
    }

    public BusinessRuleException(String message) {
        super(message);
    }

    public BusinessRuleException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessRuleException(Throwable cause) {
        super(cause);
    }
}
