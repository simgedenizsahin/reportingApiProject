package com.denizsahin.demoApiProject.model;

import lombok.Data;

@Data
public class DtoReportResponse {
    private Integer count;
    private Integer total;
    private String currency;
}
