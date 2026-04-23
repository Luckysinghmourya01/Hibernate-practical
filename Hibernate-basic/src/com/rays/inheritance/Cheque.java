package com.rays.inheritance;

public class Cheque extends Payment {

	private String cheName;
	private String bankName;

	public String getCheName() {

		return cheName;
	}

	public void setCheName(String cheName) {
		this.cheName = cheName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
