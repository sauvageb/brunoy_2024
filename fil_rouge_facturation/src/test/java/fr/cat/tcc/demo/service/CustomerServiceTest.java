package fr.cat.tcc.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.cat.tcc.demo.controller.dto.CreateCustomer;
import fr.cat.tcc.demo.controller.dto.CustomerBalance;
import fr.cat.tcc.demo.entity.Customer;
import fr.cat.tcc.demo.entity.Invoice;
import fr.cat.tcc.demo.entity.InvoiceStatus;
import fr.cat.tcc.demo.repository.CustomerRepository;
import fr.cat.tcc.demo.service.mapper.CustomerMapper;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

	@InjectMocks // Mockito d'instancier ce service avec les mocks associés (Bouchon)
	private CustomerService customerService;
	@Mock
	private CustomerRepository customerRepository;
	@Mock
	private CustomerMapper customerMapper;

	
	@Test
	void myLastTest() {
		// GIVEN
		Invoice i1 = new Invoice();
		i1.setStatus(InvoiceStatus.PAID);
		i1.setTotalIncludingVAT(120);
		i1.setTotalExcludingVAT(100);
		
		Invoice i2 = new Invoice();
		i2.setStatus(InvoiceStatus.ISSUED);
		i2.setTotalIncludingVAT(1200);
		i2.setTotalExcludingVAT(1000);
		
		Customer c1 = new Customer();
		c1.setInvoices(List.of(i1, i2));
		List<Customer> customers = List.of(c1);
		when(customerRepository.findAll()).thenReturn(customers);	
		
		// WHEN
		List<CustomerBalance> result = customerService.fetchCustomerBalances();
		
		// THEN
		assertThat(result).hasSize(customers.size());
		assertThat(result.get(0).getTotalInvoices()).isEqualTo(1320);
		assertThat(result.get(0).getStatus()).isEqualTo("En attente");
		assertThat(result.get(0).getCustomerName()).isEqualTo(c1.getName());
		assertThat(result.get(0).getTotalCashedIn()).isEqualTo(120);
		assertThat(result.get(0).getTotalBalance()).isEqualTo(1200);
		assertThat(result.get(0).isWithOutstanding()).isTrue();
	}
	
	
	
	
	@Test
	void mySecondTest() {
		// GIVEN
		CreateCustomer dto = new CreateCustomer();
		dto.setName("Boris");
		Customer customer = new Customer();
		customer.setName("Boris");
		when(customerMapper.fromDto(dto)).thenReturn(customer);
	
		// WHEN
		customerService.createCustomer(dto);

		// TEST		
		verify(customerRepository, times(1)).save(customer);
		verify(customerRepository).save(customer);
	}

	@Test // JUnit : Dépendance pour écrire des tests en Java
	@DisplayName("Addition de a et b donne la somme correcte")
	void myFirstTest() {
		// GIVEN
		int a = 20;
		int b = 100;

		// WHEN
		int result = a + b;

		// THEN
		assertThat(result).isEqualTo(120);
	}

}
