package me.siyoon.tistoryapitest;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TistoryApiClient {
    private final RestTemplate restTemplate;

    public TistoryApiClient() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * 인증 요청 및 Authentication code 발급
     * https://tistory.github.io/document-tistory-apis/auth/authorization_code.html
     */
    public void getAuthCode() {
        final String appId = "76a2f883a9b9caf68d6c7223481a44fd";
        final String callBackUri = "http://localhost:5000/callback";
        final String url = "https://www.tistory.com/oauth/authorize?client_id="
                + appId + "&redirect_uri=" + callBackUri + "&response_type=code";

        System.out.println(url);

        //이 행위는 블로그 주인이 api를 통한 접근을 허용 할 것인지 묻는 페이지로 가는 것이구나
        //인증된 블로그 유저(주인이)가 '허가하기'를 누르면 콜백 uri로 code를 보내준다.
        //ex http://localhost:5000/callback?code=908aae3bebc80055310bd1f1a04290201eb001a7e6bad11652b5a419ab2a4b2810e46227&state=
    }
}
