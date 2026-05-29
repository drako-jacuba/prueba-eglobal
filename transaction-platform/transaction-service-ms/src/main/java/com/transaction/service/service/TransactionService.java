package com.transaction.service.service;


import com.transaction.service.dto.request.CancelTransactionRequest;
import com.transaction.service.dto.request.TransactionRequest;
import com.transaction.service.dto.response.TransactionResponse;
import com.transaction.service.entity.TransactionEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TransactionService {

    TransactionResponse saveTransaction(TransactionRequest request);
    String cancelTransaction(CancelTransactionRequest request);
    Page<TransactionEntity> getTransactions(
            int page,
            int size,
            String sortBy
    );


    List<TransactionResponse> findAll();
    TransactionResponse findByReference(String reference);

}