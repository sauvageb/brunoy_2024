package fr.cat.tcc.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.cat.tcc.demo.controller.dto.CreateCustomer;
import fr.cat.tcc.demo.controller.dto.CustomerBalance;
import fr.cat.tcc.demo.controller.dto.CustomerDto;
import fr.cat.tcc.demo.entity.Customer;
import fr.cat.tcc.demo.entity.Invoice;
import fr.cat.tcc.demo.entity.InvoiceStatus;
import fr.cat.tcc.demo.repository.CustomerRepository;
import fr.cat.tcc.demo.service.mapper.CustomerMapper;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;

	public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
		this.customerRepository = customerRepository;
		this.customerMapper = customerMapper;
	}

	public void createCustomer(CreateCustomer newCustomer) {
		Customer customerEntity = customerMapper.fromDto(newCustomer);
		customerRepository.save(customerEntity);
	}
	
	public List<CustomerDto> fetchCustomers(){
		return customerRepository
				.findAll()
				.stream()
				.map(c -> customerMapper.toDto(c))
				.toList();
	}

	public List<CustomerBalance> fetchCustomerBalances() {
		List<Customer> customerList = customerRepository.findAll();
		
		List<CustomerBalance> customerBalanceList = new ArrayList<>();
		for (Customer customerEntity : customerList) {
			double totalInvoices = 0;
			double totalCashedIn = 0;
			
			for (Invoice invoiceEntity : customerEntity.getInvoices()) {
				InvoiceStatus status = invoiceEntity.getStatus();
				if(status.isIssued() || status.isSent() || status.isPaid()) {
					totalInvoices += invoiceEntity.getTotalIncludingVAT();
				}	
				if(status == InvoiceStatus.PAID) {
					totalCashedIn += invoiceEntity.getTotalIncludingVAT();
				}
			}
			CustomerBalance dto = new CustomerBalance();
			dto.setCustomerName(customerEntity.getName());	
			dto.setTotalInvoices(totalInvoices);
			dto.setTotalCashedIn(totalCashedIn);
			double balance = totalInvoices - totalCashedIn;
			dto.setTotalBalance(balance);
			
			dto.setWithOutstanding(balance > 0);
			dto.setStatus(balance > 0 ? "En attente" : "A jour");
			
			customerBalanceList.add(dto);
		}
		
		return customerBalanceList;
	}

}
