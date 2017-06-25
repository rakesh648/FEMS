package com.f11.fems.service.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.f11.fems.core.entity.Owner;
import com.f11.fems.core.si.OwnerService;
import com.f11.fems.service.exceptions.BadRequestException;
import com.f11.fems.service.exceptions.MandatoryFieldsMissingException;
import com.f11.fems.service.exceptions.ResourceNotFoundException;
import com.f11.fems.service.resource.OwnerResource;

@CrossOrigin
@RestController
public class OwnerServiceControler {
	
	private static final String NEW_OWNER_REL = "newOwner";
	private static final String OWNERS_FUNDS_REL =  "ownersFunds";
	private static final String ALL_OWNERS_REL =  "allOwners";
	private static final String RESOURCE_NAME =  "owner";
	
	private final OwnerService ownerService;
	
	@Autowired
	public OwnerServiceControler(OwnerService ownerService){
		this.ownerService = ownerService;
	}
	
	@RequestMapping(value = "/owners", method = RequestMethod.GET, 
			produces = {"application/json", "application/xml" })
	  @ResponseBody
	  @ResponseStatus(HttpStatus.OK)
   public Collection<OwnerResource> getOwners() {
	 Collection<OwnerResource> ownerResources = new ArrayList<>();
	 for(Owner owner:ownerService.findAll()){
		 OwnerResource ownerResource = new OwnerResource(owner);
		 addCommonLinks(ownerResource);
		 ownerResources.add(ownerResource);
	 }
     return ownerResources;
	}
	
	@RequestMapping(value = "/owners/{id}", method = RequestMethod.GET, 
				produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	   @ResponseBody
	   @ResponseStatus(HttpStatus.OK)
	   public OwnerResource getOwner(@PathVariable(value = "id") Long id) {
		
		 Optional<Owner> resource = ownerService.findById(id);
		 if(!resource.isPresent()){
			 throw new ResourceNotFoundException(RESOURCE_NAME, id);
			}
		 OwnerResource ownerResource = new OwnerResource(resource.get());
		 addCommonLinks(ownerResource);
	     return ownerResource;
	   }
	

	@RequestMapping(value = "/owners", method = RequestMethod.POST, 
			produces = {"application/json", "application/xml" })
	  @ResponseBody
	  @ResponseStatus(HttpStatus.CREATED)
	  public OwnerResource saveOwner( @RequestBody OwnerResource ownerResource) {
		validate(ownerResource);
		ownerService.save(ownerResource.getOwner());	 
		return getOwner(ownerResource.getOwner().getId());
	  }
	
	 private static final void validate(OwnerResource ownerResource){
		 if(ownerResource.getOwner()==null){
				throw new BadRequestException("owner object is empty");
		 }
		if(ownerResource.getOwner().getId() != null){
			throw new BadRequestException("Resouce ID must not be filled during creation");
		}
		if(ownerResource.getOwner().getName() == null){
			throw new MandatoryFieldsMissingException("name");
		}
		if(ownerResource.getOwner().getEmail() == null){
			throw new MandatoryFieldsMissingException("email");
		}
		if(ownerResource.getOwner().getPhone() == null){
			throw new MandatoryFieldsMissingException("phone");
		}
	 }
	
	
	
	private static void addCommonLinks(OwnerResource ownerResource){
		 Owner owner = ownerResource.getOwner();
		 ownerResource.add(linkTo(methodOn(OwnerServiceControler.class).getOwner(owner.getId())).withSelfRel());
		 ownerResource.add(linkTo(methodOn(OwnerServiceControler.class).saveOwner(ownerResource)).withRel(NEW_OWNER_REL));
		 ownerResource.add(linkTo(methodOn(FundServiceControler.class).getOwnersFunds(owner.getId())).withRel(OWNERS_FUNDS_REL));
		 ownerResource.add(linkTo(methodOn(OwnerServiceControler.class).getOwners()).withRel(ALL_OWNERS_REL));
	}

}
