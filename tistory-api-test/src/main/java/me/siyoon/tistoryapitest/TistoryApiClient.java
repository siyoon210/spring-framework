package me.siyoon.tistoryapitest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TistoryApiClient {
    private static final String APP_ID = "76a2f883a9b9caf68d6c7223481a44fd"; //client id 라고도 한다.
    private static final String CALL_BACK_URI = "http://localhost:5000/callback"; //redirect uri 라고도 한다.
    private static final String SECRET_KEY = "76a2f883a9b9caf68d6c7223481a44fd87ee4dacbb700fce5f22a3bac74494189e023038";
    private final RestTemplate restTemplate;

    public TistoryApiClient() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * 인증 요청하는 페이지 주소 생성 (Authentication code 발급받기 위한 동의 페이지)
     * https://tistory.github.io/document-tistory-apis/auth/authorization_code.html
     */
    public void printAuthCodeAgreementPageUri() {
        final String url = "https://www.tistory.com/oauth/authorize?client_id="
                + APP_ID + "&redirect_uri=" + CALL_BACK_URI + "&response_type=code";

        System.out.println(url);

        //이 행위는 블로그 주인이 api를 통한 접근을 허용 할 것인지 묻는 페이지로 가는 것이구나
        //인증된 블로그 유저(주인이)가 '허가하기'를 누르면 콜백 uri로 code를 보내준다.
        //ex http://localhost:5000/callback?code=908aae3bebc80055310bd1f1a04290201eb001a7e6bad11652b5a419ab2a4b2810e46227&state=
    }

    /**
     * 티스토리에서 보내주는 auth code 를 받는 콜백 경로
     */
    @GetMapping("/callback")
    @ResponseBody
    public String callBack(@RequestParam(required = false) String code) {
        System.out.println("code = " + code);
        getAccessToekn(code);
        return code;
    }

    /**
     * 전달받은 Auth Code 로 Access Token 발급받기
     * https://tistory.github.io/document-tistory-apis/auth/authorization_code.html
     */
    private void getAccessToekn(String code) {
        final String url = "https://www.tistory.com/oauth/" + "access_token"
                + "?client_id=" + APP_ID
                + "&client_secret" + SECRET_KEY
                + "&redirect_uri=" + CALL_BACK_URI
                + "&code=" + code
                + "&grant_type=authorization_code"; //Implicit 방식과 구분하기 위해 사용하며 항상 authorization_code를 사용합니다.

        System.out.println("url = " + url);

//        final Object forObject = restTemplate.getForObject(url, Object.class);
//        System.out.println("forObject = " + forObject);
    }
}
