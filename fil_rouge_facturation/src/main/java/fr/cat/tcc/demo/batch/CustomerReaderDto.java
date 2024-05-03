package fr.cat.tcc.demo.batch;

public class CustomerReaderDto {
	private String name;
	private String status;
	private String email;
	private String phone;
	private String iban;
	private String bic;
	private String address;
	private String complement;
	private String zipcode;
	private String city;
	private String country;
	private String intracommunityTVA;
	private String businessIdentification;
	
	public CustomerReaderDto() {
		super();
	}


	public String getName() {
		return name;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
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

	public String getIntracommunityTVA() {
		return intracommunityTVA;
	}

	public void setIntracommunityTVA(String intracommunityTVA) {
		this.intracommunityTVA = intracommunityTVA;
	}

	public String getBusinessIdentification() {
		return businessIdentification;
	}

	public void setBusinessIdentification(String businessIdentification) {
		this.businessIdentification = businessIdentification;
	}
	
}
