package com.denizsahin.demoApiProject.controller.impl;

import com.denizsahin.demoApiProject.controller.ITransactionController;
import com.denizsahin.demoApiProject.controller.RestBaseController;
import com.denizsahin.demoApiProject.controller.RootEntity;
import com.denizsahin.demoApiProject.model.RequestTransaction;
import com.denizsahin.demoApiProject.model.ResponseTransaction;
import com.denizsahin.demoApiProject.service.ITransactionService;
import com.denizsahin.demoApiProject.service.impl.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/get")
public class TransactionController extends RestBaseController implements ITransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/transaction")
    public RootEntity<ResponseTransaction> saveTransaction(@Valid @RequestBody RequestTransaction list) {
        return ok(transactionService.saveTransaction(list));

    }
}
