package com.samyak.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samyak.spring.entity.Customer;
import com.samyak.spring.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerServie;
	
	@GetMapping("/list")
//	@RequestMapping(path = "/list",method = RequestMethod.GET)
	public String listCutomers(Model theModel) {
		
		List<Customer>customerList = customerServie.getCustomers();
		
		theModel.addAttribute("customers", customerList);
		
		return "list-customers";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-add";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerServie.addCustomer(theCustomer);
		
		return "redirect:/customers/list";
	}
	
	@GetMapping("/showFormToUpdate")
	public String showFormToUpdate(@RequestParam("customerId")int theId, Model theModel) {
		Customer theCustomer = customerServie.getCustomer(theId);
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-add";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId")int theId) {
		customerServie.deleteCustomer(theId);
		
		return "redirect:/customers/list";
	}
	
}
