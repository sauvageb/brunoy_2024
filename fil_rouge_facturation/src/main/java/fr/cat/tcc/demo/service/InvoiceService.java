package fr.cat.tcc.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.cat.tcc.demo.controller.dto.CreateInvoice;
import fr.cat.tcc.demo.controller.dto.InvoiceLineDetails;
import fr.cat.tcc.demo.entity.Customer;
import fr.cat.tcc.demo.entity.Invoice;
import fr.cat.tcc.demo.entity.InvoiceStatus;
import fr.cat.tcc.demo.repository.CustomerRepository;
import fr.cat.tcc.demo.repository.InvoiceRepository;
import fr.cat.tcc.demo.service.mapper.InvoiceMapper;

@Service
public class InvoiceService {

	private InvoiceMapper invoiceMapper;
	private InvoiceRepository invoiceRepository;
	private CustomerRepository customerRepository;

	public InvoiceService(InvoiceMapper invoiceMapper, InvoiceRepository invoiceRepository,
			CustomerRepository customerRepository) {
		this.invoiceMapper = invoiceMapper;
		this.invoiceRepository = invoiceRepository;
		this.customerRepository = customerRepository;
	}

	public void createInvoice(CreateInvoice dto) {
		Invoice invoiceEntity = new Invoice();
		invoiceEntity.setTotalExcludingVAT(dto.getTotalExcludingVAT());
		invoiceEntity.setTotalIncludingVAT(dto.getTotalExcludingVAT() * (dto.getTva()+100)/100);
		
		if(dto.getIssueDate() == null) {
			invoiceEntity.setCreatedDate(LocalDate.now());
		}else {
			invoiceEntity.setCreatedDate(dto.getIssueDate());
		}	
		
		// TODO : reference facture
		invoiceEntity.setReference("F000...");
		
		invoiceEntity.setInvoiceName(dto.getInvoiceName());
		invoiceEntity.setInvoiceLines(List.of(dto.getContent()));
		
		invoiceEntity.setStatus(InvoiceStatus.ISSUED);
		
		Customer customerEntity = customerRepository
				.findById(dto.getCustomerId()).orElseThrow();
		invoiceEntity.setCustomer(customerEntity);
		
		invoiceRepository.save(invoiceEntity);
	}

	public List<InvoiceLineDetails> fetchInvoices() {
		List<Invoice> invoiceList = (List<Invoice>) invoiceRepository.findAll();
		return invoiceList .stream() .map(i ->invoiceMapper.toDto(i)) .toList();
	}

}
