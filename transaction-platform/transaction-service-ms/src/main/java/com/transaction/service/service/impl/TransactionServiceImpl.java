package com.transaction.service.service.impl;

import com.transaction.service.dto.request.CancelTransactionRequest;
import com.transaction.service.dto.request.TransactionRequest;
import com.transaction.service.dto.response.TransactionResponse;
import com.transaction.service.entity.TransactionEntity;
import com.transaction.service.repository.TransactionRepository;
import com.transaction.service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    @Override
    public TransactionResponse saveTransaction(TransactionRequest request) {

        String reference = generateReference();

        TransactionEntity entity = TransactionEntity.builder()
                .operation(request.getOperation())
                .amount(request.getAmount())
                .client(request.getClient())
                .reference(reference)
                .status("Aprobada")
                .secret(request.getSecret())
                .build();

        TransactionEntity saved = repository.save(entity);

        return TransactionResponse.builder()
                .id(entity.getId())
                .reference(entity.getReference())
                .client(entity.getClient())
                .operation(entity.getOperation())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public String cancelTransaction(CancelTransactionRequest request) {

        int updated = repository.updateTransactionStatus(
                request.getId(),
                request.getReference(),
                "Cancelada"
        );

        if(updated > 0) {
            return "Transaction canceled successfully";
        }

        return "Transaction not found";
    }

    @Override
    public Page<TransactionEntity> getTransactions(int page, int size, String sortBy) {


            Pageable pageable = PageRequest.of(
                    page,
                    size,
                    Sort.by(sortBy)
            );

            return repository.findAll(pageable);
    }


    @Override
    public List<TransactionResponse> findAll() {

        return repository.findAll()
                .stream()
                .map(this::buildResponse)
                .toList();
    }

    @Override
    public TransactionResponse findByReference(
            String reference
    ) {

        TransactionEntity entity =
                repository.findByReference(reference)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Transaction not found"
                                )
                        );

        return buildResponse(entity);
    }

    private String generateReference() {

        Random random = new Random();

        int number = 100000 + random.nextInt(900000);

        return String.valueOf(number);
    }


    private TransactionResponse buildResponse(TransactionEntity entity) {
        return TransactionResponse.builder()
                .id(entity.getId())
                .status(entity.getStatus())
                .reference(entity.getReference())
                .operation(entity.getOperation())
                .client(entity.getClient())
                .build();
    }

}
