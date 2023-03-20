package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Billing;

public interface BillingService {
	
	public void generatebill(Billing bill);

	public List<Billing> getAllBill();

}
