package com.f11.fems.core.si;

import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.f11.fems.core.entity.PlannedExpense;
import com.f11.fems.core.entity.type.ExpenseCategory;
import com.f11.fems.core.util.PlanSummaryVo;

@Service
public interface PlannedExpenseService {

	Optional<PlannedExpense> findById(Long id);	
	void save(PlannedExpense plannedExpense);
	Collection<PlannedExpense> findByCategory(ExpenseCategory category);
	Collection<PlannedExpense> findAll();	
	Collection<PlanSummaryVo> getSummary(); 
}
