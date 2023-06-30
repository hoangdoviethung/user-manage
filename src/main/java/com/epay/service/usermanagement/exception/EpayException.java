package com.epay.service.usermanagement.exception;

import java.util.Map;

public class EpayException extends RuntimeException {

    private ErrorStatus errorStatus;

    private String errorMessage;

    private Map<String, Object> details;

    public EpayException(ErrorStatus errorStatus) {
        super();
        this.errorStatus = errorStatus;
    }

    public EpayException(ErrorStatus errorStatus, Map<String, Object> details) {
        super();
        this.errorStatus = errorStatus;
        this.details = details;
    }

    public EpayException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public ErrorStatus getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(ErrorStatus errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }
}
