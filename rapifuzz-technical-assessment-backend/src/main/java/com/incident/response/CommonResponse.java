package com.incident.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResponse {
    
    public String status;
    public int errorCode;

    public CommonResponse(String status, int errorCode) {
        this.status = status;
        this.errorCode = errorCode;
    }

	// Getter and setter for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and setter for errorCode
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}


