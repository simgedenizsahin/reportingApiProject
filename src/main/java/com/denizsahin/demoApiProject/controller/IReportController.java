package com.denizsahin.demoApiProject.controller;

import com.denizsahin.demoApiProject.model.RequestReport;
import com.denizsahin.demoApiProject.model.ResponseReport;
import org.springframework.http.ResponseEntity;

public interface IReportController {
    public RootEntity<ResponseReport> saveReport(RequestReport report);
}
