package com.capgemini.payment.domain;

import lombok.Data;

@Data
public class Response<T> {
	private T data;
	private String status;
	private AppError error;
	
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public AppError getError() {
		return error;
	}
	public void setError(AppError error) {
		this.error = error;
	}
	public String getStatuss(){
		return error !=null ? "ERROR" :"SUCCESS";
	}
	
}
