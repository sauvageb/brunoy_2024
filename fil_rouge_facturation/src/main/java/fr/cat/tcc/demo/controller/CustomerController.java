package fr.cat.tcc.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.cat.tcc.demo.controller.dto.CreateCustomer;
import fr.cat.tcc.demo.controller.dto.CustomerBalance;
import fr.cat.tcc.demo.service.CustomerService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private JobLauncher jobLauncher;

	private Job jobCustomerImport;

	private CustomerService customerService;

	public CustomerController(JobLauncher jobLauncher, Job jobCustomerImport, CustomerService customerService) {
		this.jobLauncher = jobLauncher;
		this.jobCustomerImport = jobCustomerImport;
		this.customerService = customerService;
	}

	@GetMapping("/import")
	public String handle() throws Exception {

		JobParameters jobParameters = new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis())
				.addString("fileName", "customers.csv")
				.toJobParameters();
		
		jobLauncher.run(jobCustomerImport, jobParameters);

		return "redirect:/customers";
	}

	@GetMapping(path = "/add")
	public String displayAddForm(Model model) {
		model.addAttribute("addCustomer", new CreateCustomer());

		List<Locale> countryCodes = Arrays.asList(Locale.getAvailableLocales());
		List<String> countryList = countryCodes.stream().filter(locale -> !locale.getCountry().isEmpty())
				.map(Locale::getDisplayCountry).distinct().sorted().toList();

		model.addAttribute("countryList", countryList);
		return "customer-add.html";
	}

	@PostMapping(path = "/add")
	public String addFormSubmission(@Valid @ModelAttribute("addCustomer") CreateCustomer newCustomer,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "customer-add.html";
		}

		// Enregistrer un customer
		customerService.createCustomer(newCustomer);
		return "redirect:/customers/add";
	}

	@GetMapping
	public String all(Model model) {
		List<CustomerBalance> customerBalanceList = customerService.fetchCustomerBalances();

		model.addAttribute("customersBalance", customerBalanceList);

		return "customer-list";
	}

}
