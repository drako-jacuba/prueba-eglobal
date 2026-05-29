package com.transaction.service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransactionRequest {

    @NotBlank
    private String operation;

    @NotNull
    private Double amount;

    @NotBlank
    private String client;

    @NotBlank
    private String secret;
}
