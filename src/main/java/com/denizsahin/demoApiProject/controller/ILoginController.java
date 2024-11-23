package com.denizsahin.demoApiProject.controller;

import com.denizsahin.demoApiProject.model.RequestLogin;
import com.denizsahin.demoApiProject.model.ResponseLogin;
import org.springframework.http.ResponseEntity;

public interface ILoginController {
    public RootEntity<ResponseLogin> saveToken(RequestLogin user);
}
