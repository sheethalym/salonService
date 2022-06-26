package com.capgemini.transformer;

import com.capgemini.payment.domain.Payment;
import com.capgemini.salon.entity.PaymentEntity;

public class PaymentTransformer {
	public static PaymentEntity transformPayment(Payment payment) {
		if(payment != null) {
			System.out.println("inside if");
			PaymentEntity entity = new PaymentEntity();
			entity.setPaymentId(payment.getPaymentId());
			entity.setType(payment.getType());
			entity.setStatus(payment.getStatus());
			entity.setCardEntity(CardTransformer.transformCard(payment.getCard()));
			System.out.println(entity);
			return entity;
		}
		return null;
	}
	
	public static Payment transformPaymentEntity(PaymentEntity entity) {
		if(entity !=null) {
			Payment payment = new Payment();
			payment.setPaymentId(entity.getPaymentId());
			payment.setType(entity.getType());
			payment.setStatus(entity.getStatus());
			payment.setCard(CardTransformer.transformCardEntity(entity.getCardEntity()));
			return payment;
		}
		return null;
	}

}
