package com.denizsahin.demoApiProject.controller.impl;

import com.denizsahin.demoApiProject.controller.RestBaseController;
import com.denizsahin.demoApiProject.controller.RootEntity;
import com.denizsahin.demoApiProject.model.RequestReport;
import com.denizsahin.demoApiProject.model.ResponseReport;
import com.denizsahin.demoApiProject.service.IReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/transactions")
public class ReportController extends RestBaseController{

    @Autowired
    private IReportService reportService;

    @PostMapping("/report")
    public RootEntity<ResponseReport> saveReport(@Valid @RequestBody RequestReport report) {
        return ok(reportService.saveReport(report));

    }
}
