package com.f11.fems.service.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.f11.fems.core.entity.ContributionSummary;
import com.f11.fems.core.si.ContributionSummaryService;

@Controller
@CrossOrigin
public class SummaryServiceControler {
	
	private final ContributionSummaryService contributionSummaryServiceervice;
	
	
	@Autowired
	public SummaryServiceControler(ContributionSummaryService service){
		this.contributionSummaryServiceervice = service;
	}
	
	
	@RequestMapping(value = "/summary/contribution", method = RequestMethod.GET, 
	produces = {"application/json", "application/xml" })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Collection<ContributionSummary> getFundSummary() {		
		return contributionSummaryServiceervice.findAll();
	}
	
}
