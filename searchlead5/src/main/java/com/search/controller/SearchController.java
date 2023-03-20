package com.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.search.dto.Lead;

@Controller
public class SearchController {
	
	@Autowired
	private LeadRestClient restClient;
	
	@RequestMapping("/search")
	public String viewSearchLeadForm() {
		return "search_lead";
		
	}
	
	@RequestMapping("/searchLead")
	public String getLead(@RequestParam("id") long id,Model model) {
		System.out.println(id);
		Lead lead = restClient.getLeadInfo(id);
		if(lead!=null) {
		     model.addAttribute("lead", lead);
		     return "lead_info";
		}else {
			model.addAttribute("msg", "No record found");
			return "search_lead";
		}
		
	}

}
