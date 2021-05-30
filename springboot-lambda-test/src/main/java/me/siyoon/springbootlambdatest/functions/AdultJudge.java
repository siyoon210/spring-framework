package me.siyoon.springbootlambdatest.functions;

import me.siyoon.springbootlambdatest.dto.AdultJudgeResponse;
import me.siyoon.springbootlambdatest.dto.UserRequest;
import org.springframework.stereotype.Component;

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
