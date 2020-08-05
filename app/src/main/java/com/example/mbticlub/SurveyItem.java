package com.example.mbticlub;


public class SurveyItem {
    String name;
    String explanation;
    int movie;
    int evlaution;

    // Generate > Constructor
    public SurveyItem(String name, String explanation, int movie, int evlaution) {
        this.name = name;
        this.explanation = explanation;
        this.movie = movie;
        this.evlaution = evlaution;
    }

    // Generate > Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return explanation;
    }

    public void setMobile(String mobile) {
        this.explanation = mobile;
    }

    public int getResId() {
        return movie;
    }

    public void setResId(int resId) {
        this.movie = resId;
    }

    public int getEvlaution() {
        return evlaution;
    }

    public void setEvlaution(int evlaution) {
        this.evlaution = evlaution;
    }
    // Generate > toString() : 아이템을 문자열로 출력
}