package com.finance.repository;

import com.finance.entity.Transaction;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.type = 'income'")
    Double getTotalIncome();

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.type = 'expense'")
    Double getTotalExpense();
    
    @Query("SELECT COUNT(DISTINCT t.transactionDate) FROM Transaction t WHERE t.type = 'expense'AND t.transactionDate >= :startDate")
    Long getExpenseDays(LocalDate startDate);
}
