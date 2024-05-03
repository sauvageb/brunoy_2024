package fr.cat.tcc.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import fr.cat.tcc.demo.controller.dto.InvoiceLineDetails;
import fr.cat.tcc.demo.entity.Customer;
import fr.cat.tcc.demo.entity.Invoice;
import fr.cat.tcc.demo.entity.InvoiceStatus;
import fr.cat.tcc.demo.repository.InvoiceRepository;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceTest {
	
	@InjectMocks
	private InvoiceService invoiceService;
	@Mock
	private InvoiceRepository invoiceRepository;
	
	@Test
	void test_fetchInvoices_Success() {
		// GIVEN
		Customer c1 = new Customer();
		c1.setName("John");
		Invoice i1 = new Invoice();
		i1.setCustomer(c1);
		i1.setStatus(InvoiceStatus.PAID);
		i1.setTotalIncludingVAT(120);
		i1.setTotalExcludingVAT(100);
		
		Invoice i2 = new Invoice();
		i2.setCustomer(c1);
		i2.setStatus(InvoiceStatus.ISSUED);
		i2.setTotalIncludingVAT(1200);
		i2.setTotalExcludingVAT(1000);
		List<Invoice> invoiceList = List.of(i1, i2);
		when(invoiceRepository.findAll()).thenReturn(invoiceList);
		// WHEN
		List<InvoiceLineDetails> results = invoiceService.fetchInvoices();
		// THEN
		assertThat(results).hasSize(2);
		assertThat(results.get(0).getTotalExcludingVAT()).isEqualTo(i1.getTotalExcludingVAT());
		assertThat(results.get(0).getTotalIncludingVAT()).isEqualTo(i1.getTotalIncludingVAT());
		assertThat(results.get(0).getStatus()).isEqualTo(i1.getStatus());
		assertThat(results.get(0).getCreatedDate()).isEqualTo(i1.getCreatedDate());
		assertThat(results.get(0).getReference()).isEqualTo(i1.getReference());
		assertThat(results.get(0).getCustomerName()).isEqualTo(i1.getCustomer().getName());
	}

}
