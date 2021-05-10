package me.siyoon.springbootlambdatest.functions;

import me.siyoon.springbootlambdatest.component.LowerCaseHelper;
import me.siyoon.springbootlambdatest.dto.UserRequest;
import me.siyoon.springbootlambdatest.dto.AdultJudgeResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

public class AdultJudge implements Function<UserRequest, AdultJudgeResponse> {
    private final LowerCaseHelper lowerCaseHelper;

    public AdultJudge(LowerCaseHelper lowerCaseHelper) {
        this.lowerCaseHelper = lowerCaseHelper;
    }

    @Override
    public AdultJudgeResponse apply(UserRequest request) {
        String name = lowerCaseHelper.toLowerCase(request.getName());

        if (request.getAge() > 20) {
            return new AdultJudgeResponse(name + " is Adult!");
        }

        return new AdultJudgeResponse(name + " is Not Adult!");
    }
}
