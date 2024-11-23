package com.denizsahin.demoApiProject.service.impl;

import com.denizsahin.demoApiProject.exception.BaseException;
import com.denizsahin.demoApiProject.exception.ErrorMessage;
import com.denizsahin.demoApiProject.exception.MessageType;
import com.denizsahin.demoApiProject.model.RequestReport;
import com.denizsahin.demoApiProject.model.ResponseList;
import com.denizsahin.demoApiProject.model.ResponseReport;
import com.denizsahin.demoApiProject.service.IReportService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class ReportService implements IReportService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Autowired
    private HttpServletRequest request;

    private static final String REPORT_API = "https://sandbox-reporting.rpdpymnt.com/api/v3/transactions/report";

    public ResponseReport saveReport(RequestReport report) {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        httpHeaders.set("Authorization", request.getHeader("Authorization"));
        String authString = Objects.requireNonNull(httpHeaders.get("Authorization")).toString();
        if(authString.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.TOKEN_EXCEPTION,null));
        }
        HttpEntity<RequestReport> entity = new HttpEntity<>(report, httpHeaders);

        try {
            ResponseEntity<ResponseReport> response = restTemplate.exchange(REPORT_API, HttpMethod.POST, entity, ResponseReport.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return response.getBody();
            }
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.TRANSACTION_REPORT_EXCEPTION, e.getMessage()));
        }
        return null;
    }
}
