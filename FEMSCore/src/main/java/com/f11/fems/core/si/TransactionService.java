package com.f11.fems.core.si;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.f11.fems.core.entity.Transaction;

@Service
public interface TransactionService {

	Optional<Transaction> findById(Long id);	
	void save(Transaction transaction);
	Collection<Transaction> findByFund(Long fundId);
	Collection<Transaction> findAll();	
}
