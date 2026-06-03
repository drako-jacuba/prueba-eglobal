package com.transaction.api.client;


import com.transaction.api.dto.request.TransactionServiceRequest;
import com.transaction.api.dto.response.TransactionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "transaction-service",
        url = "http://localhost:8002"
)
public interface TransactionFeignClient {

    @PostMapping("/transactions")
    TransactionResponse saveTransaction(@RequestBody TransactionServiceRequest request);

    @GetMapping("/transactions")
    Page<TransactionResponse> findAll(
            @RequestParam Integer page,
            @RequestParam Integer size
    );

    @GetMapping("/transactions/{reference}")
    TransactionResponse findByReference(
            @PathVariable String reference
    );
}
