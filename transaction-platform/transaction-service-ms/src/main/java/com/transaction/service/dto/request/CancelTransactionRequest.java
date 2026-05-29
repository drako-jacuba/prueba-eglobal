package com.transaction.service.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CancelTransactionRequest {

    @NotNull
    private Long id;

    @NotNull
    private String reference;

    @NotNull
    private String status;
}
