package com.f11.fems.core.si;

import java.util.Collection;
import java.util.Optional;

import com.f11.fems.core.entity.Owner;

public interface OwnerService  {	
	
	Optional<Owner> findById(Long id);	
	Collection<Owner> findAll();	
	void save(Owner t);	
	
}
