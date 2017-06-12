package com.f11.fems.core.si;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.f11.fems.core.dao.OwnerDao;
import com.f11.fems.core.entity.Owner;

@Service 
class OwnerServiceImpl  implements OwnerService{
	
	@Autowired
	OwnerDao ownerRepo;

	@Override
	public Optional<Owner> findById(Long id) {
		// TODO Auto-generated method stub
		return ownerRepo.findById(id);
	}

	@Override
	public Collection<Owner> findAll() {
		// TODO Auto-generated method stub
		return ownerRepo.findAll();
	}

	@Override
	public void save(Owner owner) {
		ownerRepo.save(owner);
		
	}

}
