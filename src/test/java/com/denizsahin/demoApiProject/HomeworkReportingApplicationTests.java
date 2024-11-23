package com.denizsahin.demoApiProject;

import com.denizsahin.demoApiProject.model.*;
import com.denizsahin.demoApiProject.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;

@SpringBootTest(classes = {HomeworkReportingApplication.class})
class HomeworkReportingApplicationTests {

    @Autowired
    private ILoginService loginService;

    @Autowired
    private IListService listService;

    @Autowired
    private IClientService clientService;

    @Autowired
    private IReportService reportService;

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private HttpHeaders httpHeaders;

    @Autowired
    private HttpServletRequest request;


    @Test
     void saveTokenTest() {
        RequestLogin req = new RequestLogin();
        req.setEmail("demo@financialhouse.io");
        req.setPassword("cjaiU8CV");
        ResponseLogin response = loginService.saveToken(req);
        Assertions.assertNotNull(response);
    }

    @Test
    void saveListTest() {
        RequestList req = new RequestList();
        httpHeaders.set("Authorization", "dfgfhdfhdh");
        req.setFromDate("2015-07-01");
        req.setToDate("2015-10-01");
        req.setStatus("ERROR");
        ResponseList response = listService.saveList(req);
        Assertions.assertNotNull(response);
    }
    @Test
    void saveReportTest() {
        RequestReport req = new RequestReport();
        httpHeaders.set("Authorization", "dfgfhdfhdh");
        req.setFromDate("2015-07-01");
        req.setToDate("2015-10-01");
        ResponseReport response = reportService.saveReport(req);
        Assertions.assertNotNull(response);
    }

    @Test
    void saveClientTest() {
        RequestClient req = new RequestClient();
        httpHeaders.set("Authorization", "dfgfhdfhdh");
        req.setTransactionId("1-1444392550-1");
        ResponseClient response = clientService.saveClient(req);
        Assertions.assertNotNull(response);
    }
    @Test
    void saveTransactionTest() {
        RequestTransaction req = new RequestTransaction();
        httpHeaders.set("Authorization", "dfgfhdfhdh");
        req.setTransactionId("1-1444392550-1");
        ResponseTransaction response = transactionService.saveTransaction(req);
        Assertions.assertNotNull(response);
    }

    }
