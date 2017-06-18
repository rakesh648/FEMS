package com.f11.fems.core.util;

import com.f11.fems.core.entity.type.FundSource;

public class FundSummaryVo {
	
	FundSource source;
	Double fundAmount;
	Double fundConsumed;
	Double fundRemaining;
	
	public FundSummaryVo(FundSource source, Double fundAmount, Double fundConsumed, Double fundRemaining){
		this.source= source;
		this.fundAmount = fundAmount;
		this.fundConsumed = fundConsumed;
		this.fundRemaining = fundRemaining;
	}

	
	public FundSource getSource() {
		return source;
	}

	public Double getFundAmount() {
		return fundAmount;
	}

	public Double getFundConsumed() {
		return fundConsumed;
	}

	public Double getFundRemaining() {
		return fundRemaining;
	}

}
