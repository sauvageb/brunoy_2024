package fr.cat.tcc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import fr.cat.tcc.demo.controller.dto.GenericResponse;
import fr.cat.tcc.demo.controller.dto.SiretValidationRequest;
import fr.cat.tcc.demo.entity.Customer;
import fr.cat.tcc.demo.repository.CustomerRepository;
import fr.cat.tcc.demo.repository.InvoiceRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		var API_URL = "http://localhost:9191/api/check/siret";
		var body = new SiretValidationRequest("7899870002050");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SiretValidationRequest> request = new HttpEntity<>(body, headers);
		
		ResponseEntity<GenericResponse<String>> response = restTemplate
				.exchange(API_URL,HttpMethod.POST, 
						request,   
						new ParameterizedTypeReference<GenericResponse<String>>() {});
		
		if (response.getStatusCode().is2xxSuccessful()) {
			System.out.println(response.getBody().getMessage());
		}else {
			System.err.println(response.getStatusCode());
		}
		
		

		Customer customer1 = new Customer();
		customer1.setName("CAT");
		customerRepository.save(customer1);

		/*
		 * Invoice invoice1 = new Invoice(); invoice1.setReference("F0001");
		 * invoice1.setCreatedDate(LocalDate.now());
		 * invoice1.setTotalExcludingVAT(1000); invoice1.setTotalIncludingVAT(1200);
		 * invoice1.setStatus(InvoiceStatus.PAID); invoice1.setCustomer(customer1);
		 * invoiceRepository.save(invoice1);
		 * 
		 * Invoice invoice2 = new Invoice(); invoice2.setReference("F0002");
		 * invoice2.setCreatedDate(LocalDate.now());
		 * invoice2.setTotalExcludingVAT(1300); invoice2.setTotalIncludingVAT(1560);
		 * invoice2.setStatus(InvoiceStatus.PAID); invoice2.setCustomer(customer1);
		 * invoiceRepository.save(invoice2);
		 */

		Customer customer2 = new Customer();
		customer2.setName("CAT 2");
		customerRepository.save(customer2);

		/*
		 * Invoice invoice3 = new Invoice(); invoice3.setReference("F0003");
		 * invoice3.setCreatedDate(LocalDate.now()); invoice3.setTotalExcludingVAT(100);
		 * invoice3.setTotalIncludingVAT(100); invoice3.setStatus(InvoiceStatus.ISSUED);
		 * invoice3.setCustomer(customer2); invoiceRepository.save(invoice3);
		 * 
		 * Invoice invoice4 = new Invoice(); invoice4.setReference("F0004");
		 * invoice4.setCreatedDate(LocalDate.now()); invoice4.setTotalExcludingVAT(100);
		 * invoice4.setTotalIncludingVAT(100); invoice4.setStatus(InvoiceStatus.PAID);
		 * invoice4.setCustomer(customer2); invoiceRepository.save(invoice4);
		 */

	}

}