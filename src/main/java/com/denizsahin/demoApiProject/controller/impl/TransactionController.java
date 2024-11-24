package com.denizsahin.demoApiProject.controller.impl;

import com.denizsahin.demoApiProject.controller.RestBaseController;
import com.denizsahin.demoApiProject.controller.RootEntity;
import com.denizsahin.demoApiProject.model.RequestTransaction;
import com.denizsahin.demoApiProject.model.ResponseTransaction;
import com.denizsahin.demoApiProject.service.ITransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/get")
public class TransactionController extends RestBaseController{

    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/transaction")
    public RootEntity<ResponseTransaction> saveTransaction(@Valid @RequestBody RequestTransaction list) {
        return ok(transactionService.saveTransaction(list));

    }
}
