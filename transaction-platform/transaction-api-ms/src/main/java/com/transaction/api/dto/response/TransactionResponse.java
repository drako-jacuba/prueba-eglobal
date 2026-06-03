package com.transaction.api.dto.response;

import lombok.Data;

@Data
public class TransactionResponse {

    private Long id;

    private String status;

    private String reference;

    private String client;

    private String operation;

}
