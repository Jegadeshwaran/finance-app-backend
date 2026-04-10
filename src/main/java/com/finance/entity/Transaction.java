package com.finance.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}



	public Boolean getIs_recurring() {
		return is_recurring;
	}

	public void setIs_recurring(Boolean is_recurring) {
		this.is_recurring = is_recurring;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;

    private String type;
    private Double amount;
    private String category;
    private String description;
    private String payment_method;
    
      
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	private Boolean is_recurring;
}
