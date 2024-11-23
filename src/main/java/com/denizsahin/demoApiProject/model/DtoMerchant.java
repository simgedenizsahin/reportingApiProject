package com.denizsahin.demoApiProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DtoMerchant {

    private Integer id;
    private String name;
    private Integer originalAmount;
    private Integer convertedAmount;
    private String originalCurrency;
    private String convertedCurrency;
    private String referenceNo;
    private String status;
    private String operation;
    private String message;
    private String created_at;
    private String transactionId;
}
