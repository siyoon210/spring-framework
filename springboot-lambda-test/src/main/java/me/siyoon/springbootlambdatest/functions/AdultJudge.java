package me.siyoon.springbootlambdatest.functions;

import me.siyoon.springbootlambdatest.component.LowerCaseHelper;
import me.siyoon.springbootlambdatest.dto.AdultJudgeResponse;
import me.siyoon.springbootlambdatest.dto.UserRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AdultJudge implements Function<UserRequest, AdultJudgeResponse> {
    @Override
    public AdultJudgeResponse apply(UserRequest request) {
        String name = request.getName();

        if (request.getAge() > 20) {
            return new AdultJudgeResponse(name + " is Adult!");
        }

        return new AdultJudgeResponse(name + " is Not Adult!");
    }
}
