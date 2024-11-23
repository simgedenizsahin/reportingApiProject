package com.denizsahin.demoApiProject.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseTransaction {
    private DtoFx fx;
    private DtoCustomerInfo customerInfo;
    private DtoMerchant merchant;
    private DtoTransaction transaction;
    private DtoAcquirer acquirer;
}
