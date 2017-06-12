package com.f11.fems.core.si;

import java.util.Collection;
import java.util.Optional;

import com.f11.fems.core.entity.Fund;

public interface FundService{

	Optional<Fund> findById(Long id);	
	Collection<Fund> findAll();	
	void save(Fund t);	
	Collection<Fund> getOwnersFunds(Long ownerId);
}
