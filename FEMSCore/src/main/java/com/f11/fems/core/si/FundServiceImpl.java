package com.f11.fems.core.si;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f11.fems.core.dao.FundDao;
import com.f11.fems.core.entity.Fund;
import com.f11.fems.core.entity.Owner;
import com.f11.fems.core.util.FundSummaryVo;

@Service
public class FundServiceImpl implements FundService {

	@Autowired
	FundDao fundRepo;

	@Override
	public Optional<Fund> findById(Long id) {
		return fundRepo.findById(id);
	}

	@Override
	public Collection<Fund> findAll() {
		return fundRepo.findAll();
	}

	@Override
	public void save(Fund fund) {
		if(fund.getId()==null){
			fund.setAvailable(fund.getAmount());
			fund.setConsumed(0D);
		}
		fundRepo.save(fund);
		
	}

	@Override
	public Collection<Fund> getOwnersFunds(Long ownerId) {
		Owner owner =new Owner();
		owner.setId(ownerId);
		return fundRepo.findByOwner(owner);
	}

	@Override
	public Collection<FundSummaryVo> getSummary() {
		return fundRepo.getSummary();
	}
	
}
