package fr.cat.tcc.demo.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate createdDate;
	private String invoiceName;
	private List<String> invoiceLines;
	private String reference;
	private double totalExcludingVAT;
	private double totalIncludingVAT;
	
	@Enumerated(EnumType.STRING)
	private InvoiceStatus status;
	
	@ManyToOne
	private Customer customer;

	public Invoice() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public List<String> getInvoiceLines() {
		return invoiceLines;
	}

	public void setInvoiceLines(List<String> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}
	
	
	
}
