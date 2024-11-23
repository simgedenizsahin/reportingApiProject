package com.denizsahin.demoApiProject.model;

import lombok.Data;

@Data
public class RequestList {
    private String fromDate;
    private String toDate;
    private String status;
    private String operation;
    private String merchantId;
    private String acquirerId;
    private String paymentMethod;
    private String errorCode;
    private String filterField;
    private String filterValue;
    private String page;

}
