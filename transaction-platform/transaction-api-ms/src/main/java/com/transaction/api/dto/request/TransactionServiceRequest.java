package com.transaction.api.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionServiceRequest {

    private String operation;

    private Double amount;

    private String client;

    private String secret;
}
