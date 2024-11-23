package com.denizsahin.demoApiProject.controller;

import com.denizsahin.demoApiProject.model.RequestTransaction;
import com.denizsahin.demoApiProject.model.ResponseTransaction;
import org.springframework.http.ResponseEntity;

public interface ITransactionController {
    public RootEntity<ResponseTransaction> saveTransaction(RequestTransaction list) ;
}
