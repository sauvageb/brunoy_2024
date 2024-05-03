package fr.cat.tcc.demo.batch.chunck;

import org.springframework.batch.item.ItemProcessor;

import fr.cat.tcc.demo.batch.CustomerReaderDto;
import fr.cat.tcc.demo.controller.dto.CreateCustomer;

public class CustomerBatchProcessor implements ItemProcessor<CustomerReaderDto, CreateCustomer> {

	@Override
	public CreateCustomer process(CustomerReaderDto item) throws Exception {
		// Logique métier de transformation
		// ...
		CreateCustomer createCustomer = new CreateCustomer();
		
		try {
		int businessId = Integer.parseInt(item.getBusinessIdentification());
		createCustomer.setBusinessIdentification(businessId);
		}catch(NumberFormatException e) {
			System.err.println("businessId n'est pas un entier");
		}
		createCustomer.setName(item.getName());
		createCustomer.setAddress(item.getAddress());
		createCustomer.setAddressComplement(item.getComplement());
		createCustomer.setBic(item.getBic());
		createCustomer.setCity(item.getCity());
		createCustomer.setCountry(item.getCountry());
		createCustomer.setPhone(item.getPhone());
		createCustomer.setZipcode(item.getZipcode());
		createCustomer.setEmail(item.getEmail());
		createCustomer.setAddress(item.getAddress());
		createCustomer.setIban(item.getIban());
		createCustomer.setIntracommunityTVA(item.getIntracommunityTVA());
		// Not available in CSV File
		createCustomer.setNotes(null);

		
		if(item.getStatus().equalsIgnoreCase("professionnel")) {
			createCustomer.setProfessional(true);
		}else {
			createCustomer.setProfessional(false);
		}
			
		return createCustomer;
	}

}
	