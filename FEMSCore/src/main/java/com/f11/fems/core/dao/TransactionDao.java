package com.f11.fems.core.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.f11.fems.core.entity.Fund;
import com.f11.fems.core.entity.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Long>{
	Collection<Transaction> findByFund(Fund fund);	
	Optional<Transaction> findById(Long id);
}
