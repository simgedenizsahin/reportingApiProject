package com.denizsahin.demoApiProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DtoCustomerInfo {
    private String email;
    private String billingFirstName;
    private String billingLastName;
    private String id;
    private String created_at;
    private String updated_at;
    private String billingCountry;
    private String number;

}
