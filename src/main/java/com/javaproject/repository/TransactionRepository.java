
package com.javaproject.repository;

import com.javaproject.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
    @Query(value = "SELECT SUM(t.amount) FROM Transaction t WHERE t.accountId = :accountId")
    Double getAccountBalance(Long accountId);
    
    @Query(value = "SELECT COUNT(t) FROM Transaction t WHERE t.accountId = :accountId AND t.amount = :amount")
    int countTransactionsByAmount(Long accountId, Double amount);
    
}
