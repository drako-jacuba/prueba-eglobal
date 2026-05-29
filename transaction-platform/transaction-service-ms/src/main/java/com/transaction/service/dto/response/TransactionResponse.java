package com.transaction.service.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionResponse {

    private Long id;

    private String status;

    private String reference;

    private String client;

    private String operation;

    private Double amount;
}
