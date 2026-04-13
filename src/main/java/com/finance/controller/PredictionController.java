package com.finance.controller;

import com.finance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/prediction")
public class PredictionController {
	
	 @Autowired
	    private TransactionRepository repository;

	    @GetMapping
	    public Map<String, Object> predict() {
	    	LocalDate startDate = LocalDate.now().minusDays(30);
	        Double income = repository.getTotalIncome();
	        Double expense = repository.getTotalExpense();
	        Long days = repository.getExpenseDays(startDate);

	        if (income == null) income = 0.0;
	        if (expense == null) expense = 0.0;
	        if (days == null || days == 0) days = 1L;
	        
	        double cashBalance = income - expense;
	        double dailyExpense = expense / days;
	        double daysLeft = dailyExpense > 0 ? cashBalance / dailyExpense : 0;

	        String status;

	        if (daysLeft < 1) {
	            status = "⚠️ Less than 1 day left";
	        } else {
	            status = "⚠️ You will run out of cash in " + (int) Math.floor(daysLeft) + " days";
	        }

	        Map<String, Object> response = new HashMap<>();
	        response.put("cashBalance", cashBalance);
	        response.put("dailyExpense", dailyExpense);
	        response.put("daysLeftExact", daysLeft);
	        response.put("daysLeft", (int) Math.floor(daysLeft));
	        response.put("status", status);

	        return response;
	    }
}
