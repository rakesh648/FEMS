package com.f11.fems.core.si;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f11.fems.core.dao.PlannedExpenseDao;
import com.f11.fems.core.entity.PlannedExpense;
import com.f11.fems.core.entity.type.ExpenseCategory;
import com.f11.fems.core.util.PlanSummaryVo;

@Service
public class PlannedExpenseServiceImpl implements PlannedExpenseService{

	
	private final PlannedExpenseDao plannedExpenseRepo;
	
	@Autowired
	PlannedExpenseServiceImpl(PlannedExpenseDao plannedExpenseRepo){
		this.plannedExpenseRepo = plannedExpenseRepo;
	}

	@Override
	public Optional<PlannedExpense> findById(Long id) {
		return plannedExpenseRepo.findById(id);
	}

	@Override
	public void save(PlannedExpense plannedExpense) {
		plannedExpenseRepo.save(plannedExpense);
	}

	@Override
	public Collection<PlannedExpense> findByCategory(ExpenseCategory category) {
		return plannedExpenseRepo.findByCategory(category);
	}

	@Override
	public Collection<PlannedExpense> findAll() {
		return plannedExpenseRepo.findAll();
	}
	
	@Override
	public Collection<PlanSummaryVo> getSummary(){
		return plannedExpenseRepo.getSummary();
	}

}
