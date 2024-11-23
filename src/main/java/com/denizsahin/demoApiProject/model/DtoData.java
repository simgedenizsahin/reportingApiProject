package com.denizsahin.demoApiProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DtoData {

    private DtoFx fx;
    private DtoCustomerInfo customerInfo;
    private DtoMerchant merchant;
    private DtoIpn ipn;
    private DtoTransaction transaction;
    private DtoAcquirer acquirer;
    private Boolean refundable;
}
