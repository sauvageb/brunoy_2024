package fr.cat.tcc.demo.controller.dto;

import java.time.LocalDate;

import fr.cat.tcc.demo.entity.InvoiceStatus;

public class InvoiceLineDetails {

	private LocalDate createdDate;
	private String reference;
	private double totalExcludingVAT;
	private double totalIncludingVAT;
	private String customerName;
	private InvoiceStatus status;
	
	public InvoiceLineDetails() {
	}
	
	public InvoiceLineDetails(LocalDate createdDate, String reference, double totalExcludingVAT,
			double totalIncludingVAT, String customerName, InvoiceStatus status) {
		this.createdDate = createdDate;
		this.reference = reference;
		this.totalExcludingVAT = totalExcludingVAT;
		this.totalIncludingVAT = totalIncludingVAT;
		this.customerName = customerName;
		this.status = status;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public double getTotalExcludingVAT() {
		return totalExcludingVAT;
	}

	public void setTotalExcludingVAT(double totalExcludingVAT) {
		this.totalExcludingVAT = totalExcludingVAT;
	}

	public double getTotalIncludingVAT() {
		return totalIncludingVAT;
	}

	public void setTotalIncludingVAT(double totalIncludingVAT) {
		this.totalIncludingVAT = totalIncludingVAT;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}
	
	

}
