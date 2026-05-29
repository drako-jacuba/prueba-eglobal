package com.transaction.api.service;

import com.transaction.api.dto.request.TransactionRequest;
import com.transaction.api.dto.response.TransactionResponse;
import org.springframework.data.domain.Page;

public interface TransactionService {
    TransactionResponse processTransaction(TransactionRequest request);
    Page<TransactionResponse> findAll(
            Integer page,
            Integer size
    );

    TransactionResponse findByReference(
            String reference
    );
}
