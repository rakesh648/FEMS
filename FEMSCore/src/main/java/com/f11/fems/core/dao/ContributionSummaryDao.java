package com.f11.fems.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.f11.fems.core.entity.ContributionSummary;

@Repository
public interface ContributionSummaryDao extends JpaRepository<ContributionSummary, Long> {
	

}
