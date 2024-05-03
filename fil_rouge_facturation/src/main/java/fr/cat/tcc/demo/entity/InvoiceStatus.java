package fr.cat.tcc.demo.entity;

public enum InvoiceStatus {
	
	DRAFT("Draft"),
	ISSUED("Issued"),
	SENT("Sent"),
	PAID("Paid");
	
	private String display;
	
	private InvoiceStatus(String status) {
		this.display = status;
	}
	
	public boolean isPaid() {
		return this.display.equals(PAID.display);
	}
	
	public boolean isDraft() {
		return this.display.equals(DRAFT.display);
	}
	
	public boolean isSent() {
		return this.display.equals(SENT.display);
	}
	
	public boolean isIssued() {
		return this.display.equals(ISSUED.display);
	}
	
}
