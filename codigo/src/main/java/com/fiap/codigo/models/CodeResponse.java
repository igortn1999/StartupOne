package com.fiap.codigo.models;

public class CodeResponse {
    private String error;
    private String execution;

    public CodeResponse(String error, String execution) {
        this.error = error;
        this.execution = execution;
    }

    public String getError() {
        return error;
    }

    public String getExecution() {
        return execution;
    }
}
