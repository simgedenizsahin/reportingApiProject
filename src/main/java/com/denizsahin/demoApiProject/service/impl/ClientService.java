package com.denizsahin.demoApiProject.service.impl;

import com.denizsahin.demoApiProject.exception.BaseException;
import com.denizsahin.demoApiProject.exception.ErrorMessage;
import com.denizsahin.demoApiProject.exception.MessageType;
import com.denizsahin.demoApiProject.model.RequestClient;
import com.denizsahin.demoApiProject.model.ResponseClient;
import com.denizsahin.demoApiProject.service.IClientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class ClientService implements IClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Autowired
    private HttpServletRequest request;

    private static final String CLIENT_API = "https://sandbox-reporting.rpdpymnt.com/api/v3/client";

    public ResponseClient saveClient(RequestClient clientRequest) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        httpHeaders.set("Authorization", request.getHeader("Authorization"));
        String authString = Objects.requireNonNull(httpHeaders.get("Authorization")).toString();
        if(authString.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.TOKEN_EXCEPTION,null));
        }
        HttpEntity<RequestClient> entity = new HttpEntity<>(clientRequest, httpHeaders);
        try {
            ResponseEntity<ResponseClient> response = restTemplate.exchange(CLIENT_API, HttpMethod.POST, entity, ResponseClient.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.CLIENT_IS_OCCURED, e.getMessage()));
        }
        return null;
    }
}
