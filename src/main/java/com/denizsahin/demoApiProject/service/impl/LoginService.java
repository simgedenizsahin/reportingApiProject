package com.denizsahin.demoApiProject.service.impl;

import com.denizsahin.demoApiProject.exception.BaseException;
import com.denizsahin.demoApiProject.exception.ErrorMessage;
import com.denizsahin.demoApiProject.exception.MessageType;
import com.denizsahin.demoApiProject.model.RequestLogin;
import com.denizsahin.demoApiProject.model.ResponseClient;
import com.denizsahin.demoApiProject.model.ResponseLogin;
import com.denizsahin.demoApiProject.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LoginService implements ILoginService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    private static final String LOGIN_API = "https://sandbox-reporting.rpdpymnt.com/api/v3/merchant/user/login";

    public ResponseLogin saveToken(RequestLogin user) {

        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<RequestLogin> entity = new HttpEntity<>(user, httpHeaders);
        try {
            ResponseEntity<ResponseLogin> response = restTemplate.exchange(LOGIN_API, HttpMethod.POST, entity, ResponseLogin.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.LOGIN_EXCEPTION, e.getMessage()));
        }
        return null;
    }
}
