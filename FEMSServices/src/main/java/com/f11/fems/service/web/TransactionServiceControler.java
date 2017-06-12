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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.f11.fems.core.entity.CashTransaction;
import com.f11.fems.core.entity.ChequeTransaction;
import com.f11.fems.core.entity.Fund;
import com.f11.fems.core.entity.OnlineTransaction;
import com.f11.fems.core.entity.PlannedTransaction;
import com.f11.fems.core.entity.Transaction;
import com.f11.fems.core.entity.type.BuildingArea;
import com.f11.fems.core.entity.type.ExpenseCategory;
import com.f11.fems.core.entity.type.TransactionGroup;
import com.f11.fems.core.entity.type.TransactionStatus;
import com.f11.fems.core.entity.type.TransactionType;
import com.f11.fems.core.exception.OutOfBudgetException;
import com.f11.fems.core.si.FundService;
import com.f11.fems.core.si.TransactionService;
import com.f11.fems.service.exceptions.BadRequestException;
import com.f11.fems.service.exceptions.ResourceNotFoundException;
import com.f11.fems.service.resource.KeyValueStoreResource;
import com.f11.fems.service.resource.TransactionResource;

@RestController
@CrossOrigin
public class TransactionServiceControler {
	
	
	private final TransactionService transactionService;
	private final FundService fundService;
	
	private static final String NEW_TRANSACTION_REL = "newTransaction";
	private static final String OWNER_REL = "owner";
	private static final String ALL_TRANSACTION_REL =  "allTransactions";
	private static final String FUND_REL =  "fund";
	private static final String RESOURCE =  "Transaction";
	
	@Autowired
	public TransactionServiceControler(TransactionService transactionService, FundService fundService){
		this.transactionService = transactionService;
		this.fundService = fundService;
	}
	
	@RequestMapping(value = "/transactions", method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	   public Collection<TransactionResource> getAllTransactions(@RequestParam("group") String group	) {
		TransactionGroup transactionGroup = getTransactionGroup(group);
		 Collection<TransactionResource> transactionResources = new ArrayList<>();
		 for(Transaction transaction:transactionService.findByTransactionGroup(transactionGroup)){
			 TransactionResource transactionResource = getAdapterTransactionResource(transaction);
			 addCommonLinks(transactionResource);
			 transactionResources.add(transactionResource);
		 }
	     return transactionResources;
	}
	
	@RequestMapping(value = "funds/{fundId}/transactions", method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Collection<TransactionResource> getFundTransactions(@PathVariable(value = "fundId") Long fundId) {
	Collection<TransactionResource> transactionResources = new ArrayList<>();
	 for(Transaction transaction:transactionService.findByFund(fundId)){
		 TransactionResource transactionResource = getAdapterTransactionResource(transaction);
		 addCommonLinks(transactionResource);
		 transactionResources.add(transactionResource);
	 }
	 return transactionResources;
	}	
	
	
	@RequestMapping(value = "/transactions", method = RequestMethod.POST, 
				produces = {"application/json", "application/xml" })
		  @ResponseBody
		  @ResponseStatus(HttpStatus.CREATED)
		  public TransactionResource saveTransaction(@Validated @RequestBody TransactionResource transactionResource) {
			validate(transactionResource);
			Transaction transaction = transactionResource.fetchTransactionInstancess(); 
		 	transactionService.save(transaction);	
			return geTransaction(transaction.getId());
		  }
	
		private final void validate(TransactionResource transactionResource){
			
		if(transactionResource.getTransactionId() != null){
			throw new BadRequestException("Resouce ID must not be filled during creation");
		}
		
		if(transactionResource != null 
				&& transactionResource.getFund() != null 
				&& transactionResource.getFund().getId() != null){
			Optional<Fund> resource = fundService.findById(transactionResource.getFund().getId());
		 	if(!resource.isPresent()){
		 		throw new ResourceNotFoundException("fund", transactionResource.getFund().getId());
		 	}
		}
	}
	 
	 @RequestMapping(value = "/transactions/{transactionId}", method = RequestMethod.GET, 
				produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
		@ResponseBody
		@ResponseStatus(HttpStatus.OK)
		   public TransactionResource geTransaction(@PathVariable(value = "transactionId") Long transactionId) {
		 	Optional<Transaction> resource = transactionService.findById(transactionId);
		 	if(!resource.isPresent()){
				throw new ResourceNotFoundException(RESOURCE, transactionId);
			}
		 	TransactionResource transactionResource = getAdapterTransactionResource(resource.get());
		     return transactionResource;
		   }
	 
	 private TransactionResource getAdapterTransactionResource(Transaction transaction){
		 TransactionResource transactionResource = null;
			if (transaction instanceof ChequeTransaction) {
				transactionResource =  new TransactionResource((ChequeTransaction)transaction);
			} else if (transaction instanceof CashTransaction){
				transactionResource =  new TransactionResource((CashTransaction)transaction);
			}
			else if (transaction instanceof PlannedTransaction){
				transactionResource =  new TransactionResource((PlannedTransaction)transaction);
			}else if (transaction instanceof OnlineTransaction){
				transactionResource =  new TransactionResource((OnlineTransaction)transaction);
			}
			return transactionResource;
	 }
	 
	 @RequestMapping(value = "/transactions/types", method = RequestMethod.GET, 
				produces = {"application/json", "application/xml" })
		  @ResponseBody
		  @ResponseStatus(HttpStatus.OK)
		  public Collection<KeyValueStoreResource> getTransactionTypes(@RequestParam(value="group", required=false) String groupString) {	
		 	TransactionGroup group = getTransactionGroup(groupString);
		 	Collection<KeyValueStoreResource> sources = new ArrayList<>();
		 	for(TransactionType type: TransactionType.values()){
		 		if(group==null || type.getTransactionGroup().equals(group)){
		 			KeyValueStoreResource store = new KeyValueStoreResource(type.name(), type.getDescription());
					sources.add(store);
			 	}
			}
			
			return sources;
		  }
	 
	 @RequestMapping(value = "/transactions/categories", method = RequestMethod.GET, 
				produces = {"application/json", "application/xml" })
		  @ResponseBody
		  @ResponseStatus(HttpStatus.OK)
		  public Collection<KeyValueStoreResource> getTransactionCategories() {	
		 	Collection<KeyValueStoreResource> sources = new ArrayList<>();
		 	for(ExpenseCategory category: ExpenseCategory.values()){
		 			KeyValueStoreResource store = new KeyValueStoreResource(category.name(), category.getDescription());
					sources.add(store);
			}
			return sources;
		  }
	 
	 @RequestMapping(value = "/transactions/statuses", method = RequestMethod.GET, 
				produces = {"application/json", "application/xml" })
		  @ResponseBody
		  @ResponseStatus(HttpStatus.OK)
		  public Collection<KeyValueStoreResource> getTransactionStatuses(@RequestParam(value="group", required=false) String groupString) {	
		 	TransactionGroup group = getTransactionGroup(groupString);		 	
		 	Collection<KeyValueStoreResource> sources = new ArrayList<>();
		 	for(TransactionStatus status: TransactionStatus.values()){
		 		if(group==null || status.getTransactionGroup().equals(group)){
		 			KeyValueStoreResource store = new KeyValueStoreResource(status.name(), status.getDescription());
					sources.add(store);
		 		}
		 			
			 }
		 	 return sources;
		  }
	 
	 @RequestMapping(value = "/buildingareas", method = RequestMethod.GET, 
				produces = {"application/json", "application/xml" })
		  @ResponseBody
		  @ResponseStatus(HttpStatus.OK)
		  public Collection<KeyValueStoreResource> getBuildingArea() {	
		 	Collection<KeyValueStoreResource> sources = new ArrayList<>();
		 	for(BuildingArea area: BuildingArea.values()){
		 			KeyValueStoreResource store = new KeyValueStoreResource(area.name(), area.getDescription());
					sources.add(store);
			}
			return sources;
		  }
	 
	 private static TransactionGroup getTransactionGroup(String groupStr){
		 if (groupStr==null) return null;
		 
		 TransactionGroup group = null;
		 switch(groupStr.toUpperCase()){
		 case "EXPENSE" : group = TransactionGroup.EXPENSE; break;
		 case "PLAN" :   group = TransactionGroup.PLAN; break;
		 }
		 return group;
		 
	 }
	 
	 @ResponseStatus(value=HttpStatus.BAD_REQUEST)
	 @ExceptionHandler(OutOfBudgetException.class)
	 public void exceptionHandler() 
	 {
	 }
	 
	
	
	private static void addCommonLinks(TransactionResource transactionResource){
		 Transaction transaction = transactionResource.fetchTransactionInstancess();
		 transactionResource.add(linkTo(methodOn(TransactionServiceControler.class).geTransaction(transaction.getId())).withSelfRel());
		 transactionResource.add(linkTo(methodOn(TransactionServiceControler.class).saveTransaction(transactionResource)).withRel(NEW_TRANSACTION_REL));
		 if(transaction.getFund()!=null && transaction.getFund().getOwner()!=null){
			 transactionResource.add(linkTo(methodOn(OwnerServiceControler.class).getOwner(transaction.getFund().getOwner().getId())).withRel(OWNER_REL));
		 }
		 if(transaction.getFund()!=null ){
			 transactionResource.add(linkTo(methodOn(FundServiceControler.class).getFund(transaction.getFund().getId())).withRel(FUND_REL));
		 }
		 transactionResource.add(linkTo(methodOn(TransactionServiceControler.class).getAllTransactions("")).withRel(ALL_TRANSACTION_REL));
	}
}
