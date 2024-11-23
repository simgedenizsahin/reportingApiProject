package com.denizsahin.demoApiProject.service.impl;

import com.denizsahin.demoApiProject.exception.BaseException;
import com.denizsahin.demoApiProject.exception.ErrorMessage;
import com.denizsahin.demoApiProject.exception.MessageType;
import com.denizsahin.demoApiProject.model.RequestTransaction;
import com.denizsahin.demoApiProject.model.ResponseReport;
import com.denizsahin.demoApiProject.model.ResponseTransaction;
import com.denizsahin.demoApiProject.service.ITransactionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Autowired
    private HttpServletRequest request;

    private static final String TRANSACTION_API = "https://sandbox-reporting.rpdpymnt.com/api/v3/transaction";

    public ResponseTransaction saveTransaction(RequestTransaction transactionRequest) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        httpHeaders.set("Authorization", request.getHeader("Authorization"));
        String authString = Objects.requireNonNull(httpHeaders.get("Authorization")).toString();
        if(authString.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.TOKEN_EXCEPTION,null));
        }
        HttpEntity<RequestTransaction> entity = new HttpEntity<>(transactionRequest, httpHeaders);
        try {
            ResponseEntity<ResponseTransaction> response = restTemplate.exchange(TRANSACTION_API, HttpMethod.POST, entity, ResponseTransaction.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.GET_TRANSACTION_EXCEPTION, e.getMessage()));
        }
        return null;
    }
}
