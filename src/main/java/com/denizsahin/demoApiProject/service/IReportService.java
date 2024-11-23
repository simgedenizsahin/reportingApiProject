package com.denizsahin.demoApiProject.service;

import com.denizsahin.demoApiProject.model.RequestReport;
import com.denizsahin.demoApiProject.model.ResponseReport;

public interface IReportService {
    public ResponseReport saveReport(RequestReport report);
}
