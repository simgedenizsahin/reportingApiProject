package com.denizsahin.demoApiProject.controller;

import com.denizsahin.demoApiProject.model.RequestClient;
import com.denizsahin.demoApiProject.model.ResponseClient;
import org.springframework.http.ResponseEntity;

public interface IClientController {
    public RootEntity<ResponseClient> saveClient(RequestClient list);
}
