package com.transaction.service.controller;

import com.transaction.service.dto.request.CancelTransactionRequest;
import com.transaction.service.dto.request.TransactionRequest;
import com.transaction.service.dto.response.TransactionResponse;
import com.transaction.service.entity.TransactionEntity;
import com.transaction.service.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {

    private final TransactionService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TransactionResponse saveTransaction(@Valid @RequestBody TransactionRequest request) {
        log.info("Secret recibido en SERVICE-MS: {}",
                request.getSecret());
        return service.saveTransaction(request);
    }
    @PatchMapping("/cancel")
    public String cancelTransaction(@Valid @RequestBody CancelTransactionRequest request) {

        return service.cancelTransaction(request);
    }

    @GetMapping
    public Page<TransactionEntity> getTransactions(

            @RequestParam(defaultValue = "0")
            int page,
            @RequestParam(defaultValue = "5")
            int size,
            @RequestParam(defaultValue = "id")
            String sortBy
    ) {

        return service.getTransactions(page, size, sortBy);
    }

    @GetMapping("/transactions")
    public List<TransactionResponse> findAll() {

        return service.findAll();
    }

    @GetMapping("/{reference}")
    public TransactionResponse findByReference(
            @PathVariable String reference
    ) {

        return service.findByReference(reference);
    }

}
