package com.denizsahin.demoApiProject.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestReport {
    @NotNull
    private String fromDate;
    @NotNull
    private String toDate;
    private String merchant;
    private String acquirer;

}
