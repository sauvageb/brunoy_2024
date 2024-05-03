package fr.cat.tcc.demo.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateCustomer {	
	
	private boolean isProfessional;
	
	@NotBlank(message = "Le nom est obligatoire")
	private String name;
	private String email;
	private String phone;
	private int businessIdentification;
	private String intracommunityTVA;
	private String iban;
	private String bic;
	// Address
	private String address;
	private String addressComplement;
	private String zipcode;
	private String city;
	private String country;
	private String notes;

	public CreateCustomer(){
		this.isProfessional = true;
	}

	public boolean isProfessional() {
		return isProfessional;
	}

	public void setProfessional(boolean isProfessional) {
		this.isProfessional = isProfessional;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getBusinessIdentification() {
		return businessIdentification;
	}

	public void setBusinessIdentification(int businessIdentification) {
		this.businessIdentification = businessIdentification;
	}

	public String getIntracommunityTVA() {
		return intracommunityTVA;
	}

	public void setIntracommunityTVA(String intracommunityTVA) {
		this.intracommunityTVA = intracommunityTVA;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressComplement() {
		return addressComplement;
	}

	public void setAddressComplement(String addressComplement) {
		this.addressComplement = addressComplement;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
