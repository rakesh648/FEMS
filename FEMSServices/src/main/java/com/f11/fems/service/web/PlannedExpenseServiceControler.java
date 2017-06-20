package com.f11.fems.service.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.f11.fems.core.entity.PlannedExpense;
import com.f11.fems.core.si.PlannedExpenseService;
import com.f11.fems.core.util.PlanSummaryVo;
import com.f11.fems.service.exceptions.BadRequestException;
import com.f11.fems.service.exceptions.ResourceNotFoundException;
import com.f11.fems.service.resource.PlannedExpenseResource;

@RestController
@CrossOrigin
public class PlannedExpenseServiceControler {
	
	
	private final PlannedExpenseService plannedExpenseService;
	
	private static final String NEW_PLANNED_EXPENSE_REL = "newPlannedExpense";
	private static final String ALL_PLANNED_EXPENSE_REL =  "allPlannedExpense";
	private static final String RESOURCE =  "plannedExpense";
	
	@Autowired
	public PlannedExpenseServiceControler(PlannedExpenseService plannedExpenseService){
		this.plannedExpenseService = plannedExpenseService;
	}
	
	@RequestMapping(value = "/plans", method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	   public Collection<PlannedExpenseResource> getAllPlans() {
		 Collection<PlannedExpenseResource> resources = new ArrayList<>();
		 for(PlannedExpense expense:plannedExpenseService.findAll()){
			 PlannedExpenseResource resource = new PlannedExpenseResource(expense);
			 addCommonLinks(resource);
			 resources.add(resource);
		 }
	     return resources;
	}
	
	@RequestMapping(value = "/plans", method = RequestMethod.POST, 
				produces = {"application/json", "application/xml" })
		  @ResponseBody
		  @ResponseStatus(HttpStatus.CREATED)
		  public PlannedExpenseResource savePlannedExpense(@Validated @RequestBody PlannedExpenseResource plannedExpenseResource) {
			validate(plannedExpenseResource);
			PlannedExpense plannedExpense = plannedExpenseResource.buildPlannedExpenseEntity();
		 	plannedExpenseService.save(plannedExpense);	
			return getPlannedExpense(plannedExpense.getId());
		  }
	
		private final void validate(PlannedExpenseResource plannedExpenseResource){
			if(plannedExpenseResource.getPlanId() != null){
				throw new BadRequestException("Resouce ID must not be filled during creation");
			}
		}
	 
	 @RequestMapping(value = "/plans/{planId}", method = RequestMethod.GET, 
				produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
		@ResponseBody
		@ResponseStatus(HttpStatus.OK)
		   public PlannedExpenseResource getPlannedExpense(@PathVariable(value = "planId") Long planId) {
		 	Optional<PlannedExpense> resource = plannedExpenseService.findById(planId);
		 	if(!resource.isPresent()){
				throw new ResourceNotFoundException(RESOURCE, planId);
			}
		 	 PlannedExpenseResource plannedExpenseResource = new PlannedExpenseResource(resource.get());
		 	 addCommonLinks(plannedExpenseResource);
		     return plannedExpenseResource;
		   }
	 
	 @RequestMapping(value = "plans/summary", method = RequestMethod.GET, 
		produces = {"application/json", "application/xml" })
		@ResponseBody
		@ResponseStatus(HttpStatus.OK)
		public Collection<PlanSummaryVo> getPlanSummary() {		
			return plannedExpenseService.getSummary();
		}
	
	private static void addCommonLinks(PlannedExpenseResource resource){
		 PlannedExpense plannedExpense = resource.buildPlannedExpenseEntity();
		 resource.add(linkTo(methodOn(PlannedExpenseServiceControler.class).getPlannedExpense(plannedExpense.getId())).withSelfRel());
		 resource.add(linkTo(methodOn(PlannedExpenseServiceControler.class).savePlannedExpense(resource)).withRel(NEW_PLANNED_EXPENSE_REL));
		 resource.add(linkTo(methodOn(PlannedExpenseServiceControler.class).getAllPlans()).withRel(ALL_PLANNED_EXPENSE_REL));
	}
}
