package com.finance.controller;

import com.finance.entity.Transaction;
import com.finance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	@Autowired
    private TransactionRepository repository;

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
    	System.out.println(transaction.getTransactionDate());
        return repository.save(transaction);
    }

    @GetMapping
    public List<Transaction> getAll() {
        List<Transaction> list = repository.findAll();
        System.out.println(list);
        return list;
    }
//    @GetMapping
//    public List<Transaction> getAll() {
//        //return repository.findAll();
//    	
//    }
}
