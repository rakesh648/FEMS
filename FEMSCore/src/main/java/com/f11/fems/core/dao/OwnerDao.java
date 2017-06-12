package com.f11.fems.core.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.f11.fems.core.entity.Owner;

public interface OwnerDao extends JpaRepository<Owner, Long>{
	
	List<Owner> findByName(String name);
	
	Optional<Owner> findById(Long id);
	
	List<Owner> findAll();
	

}
