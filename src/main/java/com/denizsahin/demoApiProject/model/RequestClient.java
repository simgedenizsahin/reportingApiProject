package com.denizsahin.demoApiProject.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestClient {
    @NotNull
    private String transactionId;

}
