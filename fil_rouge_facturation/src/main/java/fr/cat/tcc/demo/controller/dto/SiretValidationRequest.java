package fr.cat.tcc.demo.controller.dto;

public class SiretValidationRequest {

	private String siret;

	
	public SiretValidationRequest(String siret) {
		super();
		this.siret = siret;
	}

	public SiretValidationRequest() {
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}
	
}
