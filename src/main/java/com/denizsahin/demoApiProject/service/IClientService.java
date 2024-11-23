package com.denizsahin.demoApiProject.service;

import com.denizsahin.demoApiProject.model.RequestClient;
import com.denizsahin.demoApiProject.model.ResponseClient;

public interface IClientService {
    public ResponseClient saveClient(RequestClient clientRequest);
}
