package com.transaction.service.repository;

import com.transaction.service.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    @Transactional
    @Modifying
    @Query("""
       UPDATE TransactionEntity t
       SET t.status = :status
       WHERE t.id = :id
       AND t.reference = :reference
       """)
    int updateTransactionStatus(
            Long id,
            String reference,
            String status
    );

    Optional<TransactionEntity> findByReference(
            String reference
    );
}