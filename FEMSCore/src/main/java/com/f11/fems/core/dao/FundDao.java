package com.f11.fems.core.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.f11.fems.core.entity.Fund;
import com.f11.fems.core.entity.Owner;

public interface FundDao extends JpaRepository<Fund, Long>{
	
	Collection<Fund> findByOwner(Owner owner);
	
	Optional<Fund> findById(Long id);
}
