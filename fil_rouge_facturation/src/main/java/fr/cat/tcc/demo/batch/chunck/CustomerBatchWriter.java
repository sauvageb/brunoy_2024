package fr.cat.tcc.demo.batch.chunck;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import fr.cat.tcc.demo.controller.dto.CreateCustomer;
import fr.cat.tcc.demo.service.CustomerService;

public class CustomerBatchWriter implements ItemWriter<CreateCustomer> {

	// pour injecter automatiquement le repository
	@Autowired
	private CustomerService customerService;

	@Override
	public void write(Chunk<? extends CreateCustomer> chunk) throws Exception {
		for(CreateCustomer dto : chunk.getItems()) {
			customerService.createCustomer(dto);
		}
	}

}
