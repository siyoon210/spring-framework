package com.example.springnativelambdatest.functions;


import com.example.springnativelambdatest.dto.AdultJudgeResponse;
import com.example.springnativelambdatest.dto.UserRequest;

import java.util.function.Function;

public class AdultJudge implements Function<UserRequest, AdultJudgeResponse> {
    @Override
    public AdultJudgeResponse apply(UserRequest request) {
        String name = request.getName();

        if (request.getAge() > 20) {
            return new AdultJudgeResponse(name + "은(는) 성인입니다.");
        }

        return new AdultJudgeResponse(name + "은(는) 성인이 아닙니다.");
    }
}
