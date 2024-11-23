package com.denizsahin.demoApiProject.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseReport {
    private String status;
    private List<DtoReportResponse> response;
}
