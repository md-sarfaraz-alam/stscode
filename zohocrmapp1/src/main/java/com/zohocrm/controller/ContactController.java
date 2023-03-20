package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Contact;
import com.zohocrm.service.BillingService;
import com.zohocrm.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private BillingService billingService;
	
	@RequestMapping("/listcontacts")
	public String listContacts(Model model) {
		List<Contact> contacts = contactService.getContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
	}
	
	@RequestMapping("/createBill")
	public String createBill(@RequestParam("id") long id,Model model) {
		Contact contact=contactService.getContactByid(id);
		model.addAttribute("contact",contact);
		return "generate_bill";
		
	}
	
	@RequestMapping("/saveBill")
	public String saveBill(Billing bill ,Model model) {
		 billingService.generatebill(bill);
		 
		model.addAttribute("billings",bill);
		
	return "list_bills";		
		
	}
	@RequestMapping("/listbill")
	public String getBill(Model model){
		List<Billing> billings = billingService.getAllBill();
		model.addAttribute("billings", billings);
	return 	"list_bills";
	}

}
