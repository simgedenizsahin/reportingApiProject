package com.denizsahin.demoApiProject.service.impl;

import com.denizsahin.demoApiProject.exception.BaseException;
import com.denizsahin.demoApiProject.exception.ErrorMessage;
import com.denizsahin.demoApiProject.exception.MessageType;
import com.denizsahin.demoApiProject.model.RequestList;
import com.denizsahin.demoApiProject.model.ResponseClient;
import com.denizsahin.demoApiProject.model.ResponseList;
import com.denizsahin.demoApiProject.service.IListService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class ListService implements IListService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Autowired
    private HttpServletRequest request;

    private static final String TRANSACTIONLIST_API = "https://sandbox-reporting.rpdpymnt.com/api/v3/transaction/list";

    public ResponseList saveList(RequestList listRequest) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.set("Authorization", request.getHeader("Authorization"));
        String authString = Objects.requireNonNull(httpHeaders.get("Authorization")).toString();
        if(authString.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.TOKEN_EXCEPTION,null));
        }
        if (listRequest.getStatus() != null) {
            boolean statuControl = List.of("APPROVED", "WAITING", "DECLINED", "ERROR")
                    .stream()
                    .anyMatch(statu -> statu.equals(listRequest.getStatus()));
            if(!statuControl){
                throw new BaseException(new ErrorMessage(MessageType.VALUE_EXCEPTION,"Statü"));
            }
        }
        if (listRequest.getOperation() != null) {
            boolean operationControl = List.of("DIRECT", "REFUND", "3D", "3DAUTH", "STORED")
                    .stream()
                    .anyMatch(operation -> operation.equals(listRequest.getOperation()));
            if(!operationControl){
                throw new BaseException(new ErrorMessage(MessageType.VALUE_EXCEPTION,"Operation Control"));
            }
        }
        if (listRequest.getPaymentMethod() != null) {
            boolean paymentControl = List.of("CREDITCARD", "CUP", "IDEAL", "GIROPAY", "MISTERCASH", "STORED",
                            "PAYTOCARD", "CEPBANK", "CITADEL")
                    .stream()
                    .anyMatch(payment -> payment.equals(listRequest.getPaymentMethod()));
            if(!paymentControl){
                throw new BaseException(new ErrorMessage(MessageType.VALUE_EXCEPTION,"Payment Control"));
            }
        }
        if (listRequest.getErrorCode() != null) {
            boolean codeControl = List.of("Do not honor", "Invalid Transaction", "Invalid Card", "Not sufficient funds", "Incorrect PIN",
                    "Invalid country association", "Currency not allowed", "3-D Secure Transport Error",
                    "Transaction not permitted to cardholder")
                    .stream()
                    .anyMatch(code -> code.equals(listRequest.getErrorCode()));
            if(!codeControl){
                throw new BaseException(new ErrorMessage(MessageType.VALUE_EXCEPTION,"Code Control"));
            }
        }
        if (listRequest.getFilterField() != null) {
            boolean fieldControl = List.of("Transaction UUID", "Customer Email", "Reference No", "Custom Data", "Card PAN")
                    .stream()
                    .anyMatch(field -> field.equals(listRequest.getFilterField()));
            if(!fieldControl){
                throw new BaseException(new ErrorMessage(MessageType.VALUE_EXCEPTION,"Field Control"));
            }
        }

        HttpEntity<RequestList> entity = new HttpEntity<>(listRequest, httpHeaders);
        try {
            ResponseEntity<ResponseList> response = restTemplate.exchange(TRANSACTIONLIST_API, HttpMethod.POST, entity, ResponseList.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.TRANSACTION_QUERY_EXCEPTION, e.getMessage()));
        }
        return null;
    }
}
