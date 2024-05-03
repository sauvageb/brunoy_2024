package fr.cat.tcc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.cat.tcc.demo.controller.dto.CreateInvoice;
import fr.cat.tcc.demo.service.CustomerService;
import fr.cat.tcc.demo.service.InvoiceService;

@Controller
@RequestMapping("/invoices")
public class InvoiceController {

	private InvoiceService invoiceService;
	private CustomerService customerService;
	
	public InvoiceController(InvoiceService invoiceService, CustomerService customerService) {
		this.invoiceService = invoiceService;
		this.customerService = customerService;
	}

	@GetMapping("/add")
	public String displayAddForm(Model model) {
		model.addAttribute("invoiceDto", new CreateInvoice());
		model.addAttribute("customers", customerService.fetchCustomers());
		return "invoice-add.html";
	}
	
	@PostMapping("/add")
	public String submitAddForm(CreateInvoice dto) {
		
		invoiceService.createInvoice(dto);
		
		return "redirect:/invoices";
	}

	@GetMapping
	public String displayAll(Model model) {
		model.addAttribute("data", invoiceService.fetchInvoices());
		
		return "invoice-list.html";
	}
	
}
