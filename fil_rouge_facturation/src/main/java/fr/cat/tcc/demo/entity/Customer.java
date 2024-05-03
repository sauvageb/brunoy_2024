package fr.cat.tcc.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Table(name = "customers")
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private boolean isProfessional;
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

	@OneToMany(mappedBy = "customer")
	private List<Invoice> invoices;
	
	
	public Customer(){
		this.isProfessional = true;
	}
	
			
	@Override
	public String toString() {
		return "Customer [isProfessional=" + isProfessional + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", businessIdentification=" + businessIdentification + ", intracommunityTVA=" + intracommunityTVA
				+ ", iban=" + iban + ", bic=" + bic + ", address=" + address + ", address_complement="
				+ addressComplement + ", zipcode=" + zipcode + ", city=" + city + ", country=" + country + ", notes="
				+ notes + "]";
	}


	public boolean isProfessional() {
		return isProfessional;
	}


	public void setProfessional(boolean isProfessional) {
		this.isProfessional = isProfessional;
	}


	public Customer(String name) {
		this.name = name;
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public List<Invoice> getInvoices() {
		return invoices;
	}


	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
	
	
	
	
	
}
