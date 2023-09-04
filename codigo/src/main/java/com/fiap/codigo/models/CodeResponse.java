package com.fiap.codigo.models;

import java.util.List;
import java.util.Map;

public class CodeResponse {
    private String error;
    private String execution;

    private List <Boolean> challengeList;


    public CodeResponse(String error, String execution, List<Boolean> challengeList) {
        this.error = error;
        this.execution = execution;
        this.challengeList = challengeList;
    }

    public String getError() {
        return error;
    }

    public String getExecution() {
        return execution;
    }

    public List<Boolean> getChallengeList() {
        return challengeList;
    }

    public void setPropertyList(List<Boolean> challengeList) {
        this.challengeList = challengeList;
    }
}
