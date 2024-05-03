package fr.cat.tcc.demo.controller.dto;

import java.time.LocalDate;

public class CreateInvoice {

	private Long customerId;
	private String invoiceName;
	private LocalDate issueDate;
	private String content;
	private double tva;
	private double totalExcludingVAT;

	public CreateInvoice() {
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getTva() {
		return tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}

	public double getTotalExcludingVAT() {
		return totalExcludingVAT;
	}

	public void setTotalExcludingVAT(double totalExcludingVAT) {
		this.totalExcludingVAT = totalExcludingVAT;
	}
}
