package com.f11.fems.service.resource.util;

import org.mapstruct.Mapper;

import com.f11.fems.core.entity.Fund;
import com.f11.fems.service.resource.FundResource;

@Mapper(componentModel = "spring")
public interface FundResourceMapper {
	
	Fund resourceToEntity(FundResource resource);
	FundResource entityToResource(Fund entity);
}
