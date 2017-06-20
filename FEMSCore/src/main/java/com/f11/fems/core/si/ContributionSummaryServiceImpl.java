package com.f11.fems.core.si;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f11.fems.core.dao.ContributionSummaryDao;
import com.f11.fems.core.entity.ContributionSummary;

@Service
public class ContributionSummaryServiceImpl  implements ContributionSummaryService{
	
	ContributionSummaryDao ContributionSummaryRepo;
	
	@Autowired
	
	ContributionSummaryServiceImpl(ContributionSummaryDao ContributionSummaryRepo){
		this.ContributionSummaryRepo = ContributionSummaryRepo;
	}

	@Override
	public Collection<ContributionSummary> findAll(){
		return ContributionSummaryRepo.findAll();
	}
}
