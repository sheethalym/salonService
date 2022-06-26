package com.capgemini.salon.Service;

import java.util.List;

import com.capgemini.payment.domain.Card;
import com.capgemini.payment.domain.Payment;
import com.capgemini.payment.domain.Response;

public interface PaymentService {
	
	public Response<Payment> addPayment(Payment Payment);

	public Response<Payment> updatePayment(Payment Payment);

	public Response<List<Payment>> getAllPayments();

	public Response<Payment> getPayment(Integer pId);
	
	public Response<Boolean> deletePayment(Integer pId);

}
