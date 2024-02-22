package org.example.microservice1.Exception;

import lombok.Data;

import java.util.ArrayList;

@Data
public class UnKnownDepartmentException extends Exception{
    private ArrayList<Error> resultMessages;
    private String traceId;
    public UnKnownDepartmentException(String msg, ArrayList<Error> resultMessages) {
        super(msg);
        this.resultMessages = resultMessages;

    }
    public UnKnownDepartmentException(String msg, ArrayList<Error> resultMessages, String traceId) {
        super(msg);
        this.resultMessages = resultMessages;
        this.traceId = traceId;
    }
}
