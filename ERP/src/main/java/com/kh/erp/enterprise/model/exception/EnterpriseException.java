package com.kh.erp.enterprise.model.exception;

public class EnterpriseException extends RuntimeException {
	
	public EnterpriseException() {}
	
	public EnterpriseException(String msg) {
		super(msg);
	}
}
