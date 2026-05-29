package com.transaction.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionRequest {

    @NotBlank(message = "Operation is required")
    @Pattern(
            regexp = "^[a-zA-Z]+$",
            message = "Only letters allowed"
    )
    private String operation;

    @NotBlank(message = "Amount is required")
    private String amount;

    @NotBlank(message = "Client is required")
    @Pattern(
            regexp = "^[a-zA-Z ]+$",
            message = "Invalid client format"
    )
    private String client;

    @NotBlank(message = "Secret is required")
    private String secret;
}
