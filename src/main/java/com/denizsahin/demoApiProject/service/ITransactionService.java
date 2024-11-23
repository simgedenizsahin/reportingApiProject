package com.denizsahin.demoApiProject.service;

import com.denizsahin.demoApiProject.model.RequestTransaction;
import com.denizsahin.demoApiProject.model.ResponseTransaction;

public interface ITransactionService {
    public ResponseTransaction saveTransaction(RequestTransaction transactionRequest);
}
