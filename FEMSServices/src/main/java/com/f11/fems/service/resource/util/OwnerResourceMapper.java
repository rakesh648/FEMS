package com.f11.fems.service.resource.util;

import org.mapstruct.Mapper;

import com.f11.fems.core.entity.Owner;
import com.f11.fems.service.resource.OwnerResource;

@Mapper(componentModel = "spring")
public interface OwnerResourceMapper {
	
	Owner resourceToEntity(OwnerResource resource);
	OwnerResource entityToResource(Owner entity);

}
