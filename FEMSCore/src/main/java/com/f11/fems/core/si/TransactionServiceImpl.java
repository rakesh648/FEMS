package com.f11.fems.core.si;

import java.util.Collection;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f11.fems.core.dao.TransactionDao;
import com.f11.fems.core.entity.Fund;
import com.f11.fems.core.entity.Transaction;
import com.f11.fems.core.entity.type.TransactionGroup;
import com.f11.fems.core.exception.OutOfBudgetException;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionDao transactionRepo;
	@Autowired
	FundService fundService;

	@Override
	public Optional<Transaction> findById(Long id) {
		return transactionRepo.findById(id);
	}


	@Override
	@Transactional
	public void save(Transaction transaction) {
		if(transaction==null || 
				transaction.getFund() == null || 
					transaction.getFund().getId() == null){
			throw new RuntimeException("Incorrect input transaction");
		}
		Optional<Fund> fundOpt = fundService.findById(transaction.getFund().getId());
		if(!fundOpt.isPresent()){
			throw new RuntimeException("fund doesn't exist. id = "+transaction.getFund().getId());
		}
		Fund fund = fundOpt.get();
		if(transaction.getAmount() >fund.getAvailable()){
			throw new OutOfBudgetException(fund.getAvailable(),transaction.getAmount());
		}else{
			fund.consumeFund(transaction.getAmount());
			fundService.save(fund);
			transactionRepo.save(transaction);	
		}
			
	}
	
	@Override
	public Collection<Transaction> findByFund(Long fundId){
		Fund fund = new Fund();
		fund.setId(fundId);
		return transactionRepo.findByFund(fund);
	}

	@Override
	public Collection<Transaction> findByTransactionGroup(TransactionGroup group) {
		return transactionRepo.findByTransactionGroup(group);
	}
}
