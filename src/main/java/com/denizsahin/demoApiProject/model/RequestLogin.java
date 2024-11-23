package com.denizsahin.demoApiProject.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestLogin {

    @NotNull
    private String email;
    @NotNull
    private String password;
}
