package com.example.Spring3_Security6.dto;
import org.springframework.stereotype.Component;
@Component
public class ErrorDto {
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    private String status;
    private String errorMessage;
    private String statusCode;
    @Override
    public String toString() {
        return "ErrorDto{" +
                "status='" + status + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}
