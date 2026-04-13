package com.finance.controller;

import com.finance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
	
	@Autowired
    private TransactionRepository repository;
	
	@GetMapping
    public Map<String, Object> getDashboard() {

        Double income = repository.getTotalIncome();
        Double expense = repository.getTotalExpense();

        if (income == null) income = 0.0;
        if (expense == null) expense = 0.0;

        Double profit = income - expense;

        Map<String, Object> response = new HashMap<>();
        response.put("totalIncome", income);
        response.put("totalExpense", expense);
        response.put("profit", profit);

        return response;
    }
}
