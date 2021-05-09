package me.siyoon.springbootlambdatest.dto;

public class AdultJudgeResponse {
    private String result;

    public AdultJudgeResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
