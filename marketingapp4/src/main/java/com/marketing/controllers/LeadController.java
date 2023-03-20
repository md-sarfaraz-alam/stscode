package com.marketing.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketing.dto.LeadData;
import com.marketing.entities.Lead;
import com.marketing.services.LeadService;
import com.marketing.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
		//Handler method
	
	//http://localhost:8080/create	
	@RequestMapping("/create")
	public String viewCreateLeadForm() {
		return "create_lead";
	}	
	
//http://localhost:8080/saveLead
	@RequestMapping("/saveLead")
	public String saveLead(@ModelAttribute("Lead") Lead lead,ModelMap model)
	{
		model.addAttribute("msg", "record is saved");
		emailService.sendEmail(lead.getEmail(),"Welcome Email","test");
		leadService.saveOneLead(lead);
		return"create_lead";
		}
	
	
	//2nd way to read form data
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("email") String email,@RequestParam("mobile") long mobile) {
//	     Lead lead=new Lead();
//	     lead.setFirstName(firstName);
//	     lead.setLastName(lastName);
//	     lead.setEmail(email);
//	     lead.setMobile(mobile);
//	  leadService.saveOneLead(lead);
//	      return"create_lead";
//
//	}
//	
	//3. first dto will take data from form and then transfer to entity class and then save to db
//	@RequestMapping("/saveLead")
//	public String saveOneLead(LeadData leadData) {
//		Lead lead =new Lead();
//	    lead.setFirstName(leadData.getFirstName());
//	    lead.setLastName(leadData.getLastName());
//	   lead.setEmail(leadData.getEmail());
//	    lead.setMobile(leadData.getMobile());
//	    leadService.saveOneLead(lead);
//	      return"create_lead";
//
//	}
	
	// to reas the data from database
	//http:localhost:8080/listall
	@RequestMapping("/listall")
	public String listLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		//System.out.println(leads);
		model.addAttribute("leads", leads);
		return"list_leads";
		
	}
	
	@RequestMapping("/delete")
	public String deleteOneLead(@RequestParam("id") long id,Model model) {
		leadService.deleteLead(id);
		
		List<Lead> leads = leadService.getAllLeads();
		//System.out.println(leads);
		model.addAttribute("leads", leads);
		return"list_leads";
	
		
	}
	
	@RequestMapping("/update")
	public String updateOneLead(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.getLeadById(id);
		model.addAttribute("lead", lead);
		return "update_lead";
		
	}
	
	//http://localhost:8080/saveLead
		@RequestMapping("/updateLead")
		public String updateOneLead(@ModelAttribute("lead") Lead lead,ModelMap model) {
			
			  leadService.saveOneLead(lead);
			  List<Lead> leads = leadService.getAllLeads();
				model.addAttribute("leads", leads);
				return"list_leads";
			}
	

}
