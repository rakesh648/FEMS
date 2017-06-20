package com.f11.fems.core.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.f11.fems.core.entity.PlannedExpense;
import com.f11.fems.core.entity.type.ExpenseCategory;
import com.f11.fems.core.util.PlanSummaryVo;

public interface PlannedExpenseDao extends JpaRepository<PlannedExpense, Long>{
	Collection<PlannedExpense> findByCategory(ExpenseCategory cateogry);	
	Optional<PlannedExpense> findById(Long id);
	
	@Query("select new com.f11.fems.core.util.PlanSummaryVo(p.category,sum(amount)) "
			+ "from PlannedExpense p group by p.category")
	Collection<PlanSummaryVo> getSummary(); 
}
