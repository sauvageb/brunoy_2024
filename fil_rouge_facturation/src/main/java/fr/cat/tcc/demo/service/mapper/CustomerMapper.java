package fr.cat.tcc.demo.service.mapper;

import org.springframework.stereotype.Component;

import fr.cat.tcc.demo.controller.dto.CreateCustomer;
import fr.cat.tcc.demo.controller.dto.CustomerDto;
import fr.cat.tcc.demo.entity.Customer;

@Component
public class CustomerMapper {

	public Customer fromDto(CreateCustomer newCustomer){
		Customer customerEntity = new Customer();
		customerEntity.setProfessional(newCustomer.isProfessional());
		customerEntity.setName(newCustomer.getName());
		customerEntity.setEmail(newCustomer.getEmail());
		customerEntity.setPhone(newCustomer.getPhone());
		customerEntity.setBusinessIdentification(newCustomer.getBusinessIdentification());
		customerEntity.setIntracommunityTVA(newCustomer.getIntracommunityTVA());
		customerEntity.setIban(newCustomer.getIban());
		customerEntity.setBic(newCustomer.getBic());
		customerEntity.setAddress(newCustomer.getAddress());
		customerEntity.setAddressComplement(newCustomer.getAddressComplement());
		customerEntity.setZipcode(newCustomer.getZipcode());
		customerEntity.setCity(newCustomer.getCity());
		customerEntity.setCountry(newCustomer.getCountry());
		customerEntity.setNotes(newCustomer.getNotes());
		return customerEntity;
	}

	
	public CustomerDto toDto(Customer c) {
		CustomerDto dto = new CustomerDto();
		dto.setId(c.getId());
		dto.setName(c.getName());
		return dto;
	}
	
}
