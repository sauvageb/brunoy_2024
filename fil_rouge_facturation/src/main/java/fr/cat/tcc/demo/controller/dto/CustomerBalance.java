package fr.cat.tcc.demo.controller.dto;

public class CustomerBalance {
	private String customerName;
	private double totalInvoices;
	private double totalCashedIn;
	private double totalBalance;
	private String status;
	private boolean withOutstanding;
	
	public CustomerBalance() {
	}
	
	public CustomerBalance(String customerName, double totalInvoices, double totalCashedIn, double totalBalance,
			String status, boolean withOutstanding) {
		this.customerName =customerName;
		this.totalInvoices = totalInvoices;
		this.totalCashedIn = totalCashedIn;
		this.totalBalance = totalBalance;
		this.status = status;
		this.withOutstanding = withOutstanding;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalInvoices() {
		return totalInvoices;
	}

	public void setTotalInvoices(double totalInvoices) {
		this.totalInvoices = totalInvoices;
	}

	public double getTotalCashedIn() {
		return totalCashedIn;
	}

	public void setTotalCashedIn(double totalCashedIn) {
		this.totalCashedIn = totalCashedIn;
	}

	public double getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(double totalBalance) {
		this.totalBalance = totalBalance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isWithOutstanding() {
		return withOutstanding;
	}

	public void setWithOutstanding(boolean withOutstanding) {
		this.withOutstanding = withOutstanding;
	}


}
