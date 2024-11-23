package com.denizsahin.demoApiProject.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestTransaction {
    @NotNull
    private String transactionId;

}
