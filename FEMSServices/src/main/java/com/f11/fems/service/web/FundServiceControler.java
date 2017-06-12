package com.f11.fems.service.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.f11.fems.core.entity.Fund;
import com.f11.fems.core.entity.Owner;
import com.f11.fems.core.entity.type.FundSource;
import com.f11.fems.core.si.FundService;
import com.f11.fems.core.si.OwnerService;
import com.f11.fems.service.exceptions.BadRequestException;
import com.f11.fems.service.exceptions.MandatoryFieldsMissingException;
import com.f11.fems.service.exceptions.ResourceNotFoundException;
import com.f11.fems.service.resource.FundResource;
import com.f11.fems.service.resource.KeyValueStoreResource;

@Controller
@CrossOrigin
public class FundServiceControler {
	
	private final FundService fundService;
	private final OwnerService ownerService;
	
	private static final String NEW_FUND_REL = "newFund";
	private static final String OWNER_REL = "owner";
	private static final String ALL_FUNDS_REL =  "allFunds";
	private static final String RESOURCE =  "fund";
	
	@Autowired
	public FundServiceControler(FundService fundService, OwnerService ownerService){
		this.fundService = fundService;
		this.ownerService = ownerService;
	}
	
	
	@RequestMapping(value = "/owners/{ownerId}/funds", method = RequestMethod.GET, 
					produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	   @ResponseBody
	   @ResponseStatus(HttpStatus.OK)
	   public Collection<FundResource> getOwnersFunds(@PathVariable(value = "ownerId") Long ownerId) {
		Collection<FundResource> fundResources = new ArrayList<>();
		 for(Fund fund:fundService.getOwnersFunds(ownerId)){
			 FundResource fundResource = new FundResource(fund);
			 addCommonLinks(fundResource);
			 fundResources.add(fundResource);
		 }
	     return fundResources;
	   }
	
	@RequestMapping(value = "/funds", method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	   public Collection<FundResource> getFunds() {
		 Collection<FundResource> fundResources = new ArrayList<>();
		 for(Fund fund:fundService.findAll()){
			 FundResource fundResource = new FundResource(fund);
			 addCommonLinks(fundResource);
			 fundResources.add(fundResource);
		 }
	     return fundResources;
	   }
	
	@RequestMapping(value = "/funds/{fundId}", method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	   public FundResource getFund(@PathVariable(value = "fundId") Long fundId) {
		Optional<Fund> resource = fundService.findById(fundId);
		if(!resource.isPresent()){
			throw new ResourceNotFoundException(RESOURCE, fundId);
		}
		FundResource fundResource = new FundResource(resource.get());
		
		 addCommonLinks(fundResource);
	     return fundResource;
	   }
	
	@RequestMapping(value = "/funds", method = RequestMethod.POST, 
			produces = {"application/json", "application/xml" })
	  @ResponseBody
	  @ResponseStatus(HttpStatus.CREATED)
	  public FundResource saveFund( @RequestBody FundResource fundResource) {	
		validate(fundResource);
		fundService.save(fundResource.getFund());	 
		return getFund(fundResource.getFund().getId());
	  }
	
	private final void validate(FundResource fundResource){
	if(fundResource.getFund()==null){
			throw new BadRequestException("Fund object is empty");
	 }
	if(fundResource.getFund().getId() != null){
		throw new BadRequestException("Resouce ID must not be filled during creation");
	}
	if(fundResource.getFund().getOwner().getId() == null){
		throw new MandatoryFieldsMissingException("owner.id");
	}
	if(fundResource.getFund().getFundSource() == null){
		throw new MandatoryFieldsMissingException("fundSource");
	}
	if(fundResource.getFund().getAmount() == null){
		throw new MandatoryFieldsMissingException("amount");
	}
	Optional<Owner> resource = ownerService.findById(fundResource.getFund().getOwner().getId());
	 if(!resource.isPresent()){
		 throw new ResourceNotFoundException("owner", fundResource.getFund().getOwner().getId());
	 }
	
	}
	
	
	@RequestMapping(value = "/funds/sources", method = RequestMethod.GET, 
			produces = {"application/json", "application/xml" })
	  @ResponseBody
	  @ResponseStatus(HttpStatus.OK)
	  public Collection<KeyValueStoreResource> getFundSources() {		
		Collection<KeyValueStoreResource> sources = new ArrayList<>();
		for(FundSource source: FundSource.values()){
			KeyValueStoreResource store = new KeyValueStoreResource(source.name(), source.getDescription());
			sources.add(store);
		}
		return sources;
	  }
	
	private static void addCommonLinks(FundResource fundResource){
		 Fund fund = fundResource.getFund();
		 fundResource.add(linkTo(methodOn(FundServiceControler.class).getFund(fund.getId())).withSelfRel());
		 fundResource.add(linkTo(methodOn(FundServiceControler.class).saveFund(fundResource)).withRel(NEW_FUND_REL));
		 fundResource.add(linkTo(methodOn(OwnerServiceControler.class).getOwner(fund.getOwner().getId())).withRel(OWNER_REL));
		 fundResource.add(linkTo(methodOn(FundServiceControler.class).getFunds()).withRel(ALL_FUNDS_REL));
	}
}
