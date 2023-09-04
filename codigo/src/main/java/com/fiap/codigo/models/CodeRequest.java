package com.fiap.codigo.models;

public class CodeRequest {
    private String code;

    private int lessonId;

    private String validationType;

    public int getLessonId(){
        return lessonId;
    }

    public void setLessonId(int lessonId){
        this.lessonId = lessonId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getValidationType(){
        return validationType;
    }
    public void setValidationType(String validationType) {
        this.validationType = validationType;
    }
}
