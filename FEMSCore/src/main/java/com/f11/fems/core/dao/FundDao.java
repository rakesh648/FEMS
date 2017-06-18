package com.f11.fems.core.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.f11.fems.core.entity.Fund;
import com.f11.fems.core.entity.Owner;
import com.f11.fems.core.util.FundSummaryVo;

public interface FundDao extends JpaRepository<Fund, Long>{
	
	Collection<Fund> findByOwner(Owner owner);
	
	Optional<Fund> findById(Long id);
	
	@Query("select new com.f11.fems.core.util.FundSummaryVo(f.fundSource,sum(amount),sum(consumed),sum(amount)-sum(consumed))  from Fund f group by f.fundSource")
	Collection<FundSummaryVo> getSummary();
}
