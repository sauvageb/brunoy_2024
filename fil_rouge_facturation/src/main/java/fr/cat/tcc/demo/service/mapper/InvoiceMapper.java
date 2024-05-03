package fr.cat.tcc.demo.service.mapper;

import org.springframework.stereotype.Component;

import fr.cat.tcc.demo.controller.dto.CreateInvoice;
import fr.cat.tcc.demo.controller.dto.InvoiceLineDetails;
import fr.cat.tcc.demo.entity.Customer;
import fr.cat.tcc.demo.entity.Invoice;

@Component
public class InvoiceMapper {

	public InvoiceLineDetails toDto(Invoice i){
		return new InvoiceLineDetails(
						i.getCreatedDate(), 
						i.getReference(), 
						i.getTotalExcludingVAT(),
						i.getTotalIncludingVAT(),
						i.getCustomer().getName(),
						i.getStatus());
	}


	
}
