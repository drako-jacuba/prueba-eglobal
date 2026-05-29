package com.transaction.api.service.impl;

import com.transaction.api.client.TransactionFeignClient;

import com.transaction.api.dto.request.TransactionRequest;
import com.transaction.api.dto.request.TransactionServiceRequest;
import com.transaction.api.dto.response.TransactionResponse;
import com.transaction.api.service.TransactionService;
import com.transaction.api.util.AESUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionFeignClient feignClient;

    @Override
    public TransactionResponse processTransaction(
            TransactionRequest request) {

        try {
            System.out.println(
                    "SECRET RECIBIDO: "
                            + request.getSecret()
            );

            String decryptedSecret =
                    /* AESUtil.decrypt()
                    * Genera un payload cifrado válido.
                    */
                    AESUtil.decrypt(
                            request.getSecret().trim()

                    );

            TransactionServiceRequest serviceRequest =
                    TransactionServiceRequest.builder()
                            .operation(request.getOperation())
                            .amount(
                                    Double.parseDouble(
                                            request.getAmount()
                                    )
                            )
                            .client(request.getClient())
                            .secret(decryptedSecret)
                            .build();

            return feignClient.saveTransaction(
                    serviceRequest
            );

        } catch (Exception e) {

            e.printStackTrace();

            throw new RuntimeException(
                    e.getMessage(),
                    e
            );
        }
    }

    @Override
    public Page<TransactionResponse> findAll(Integer page, Integer size) {
        return feignClient.findAll(
                page,
                size
        );
    }

    @Override
    public TransactionResponse findByReference(String reference) {
        return feignClient.findByReference(
                reference
        );
    }
}
