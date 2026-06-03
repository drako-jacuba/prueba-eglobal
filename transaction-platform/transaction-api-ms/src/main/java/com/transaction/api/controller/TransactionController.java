package com.transaction.api.controller;


import com.transaction.api.dto.request.TransactionRequest;
import com.transaction.api.dto.response.TransactionResponse;
import com.transaction.api.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@Slf4j
public class TransactionController {

    private final TransactionService service;

    @PostMapping
    public TransactionResponse processTransaction(@Valid @RequestBody TransactionRequest request) {
        log.info("Secret recibido en API-MS: {}",
                request.getSecret());
        return service.processTransaction(request);
    }

    @GetMapping
    public Page<TransactionResponse> findAll(
            @RequestParam(defaultValue = "0")
            Integer page,

            @RequestParam(defaultValue = "5")
            Integer size
    ) {

        return service.findAll(
                page,
                size
        );
    }

    @GetMapping("/{reference}")
    public TransactionResponse findByReference(
            @PathVariable String reference
    ) {

        return service.findByReference(
                reference
        );
    }
}
