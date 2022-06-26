package com.capgemini.salon.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.payment.domain.AppError;
import com.capgemini.payment.domain.Card;
import com.capgemini.payment.domain.Payment;
import com.capgemini.payment.domain.Response;
import com.capgemini.salon.dao.CardDao;
import com.capgemini.salon.dao.PaymentDao;
import com.capgemini.salon.entity.CardEntity;
import com.capgemini.salon.entity.PaymentEntity;
import com.capgemini.transformer.CardTransformer;
import com.capgemini.transformer.PaymentTransformer;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private CardDao cardDao;

	@Override
	public Response<Payment> addPayment(Payment payment) {
		Response<Payment> response = new Response<>();
		try {
			System.out.println("starting add service");
			System.out.println(payment);
		PaymentEntity entity = paymentDao.save(PaymentTransformer.transformPayment(payment));
		response.setData(PaymentTransformer.transformPaymentEntity(entity));
		System.out.println("data is set");
		
		//PaymentEntity entity = PaymentTransformer.transformPayment(payment);
		//entity.setCardEntity(cardDao.findById(payment.getCard().getId()).orElse(null));
		//entity = paymentDao.save(entity);
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_ADDING PAYMENT");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}

	@Override
	public Response<Payment> updatePayment(Payment payment) {
		Response<Payment> response = new Response<>();
		try {
		PaymentEntity entity = paymentDao.save(PaymentTransformer.transformPayment(payment));
		response.setData(PaymentTransformer.transformPaymentEntity(entity));
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_UPDATING PAYMENT");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}

	@Override
	public Response<List<Payment>> getAllPayments() {
		Response<List<Payment>> response = new Response<>();
		try {
		List<PaymentEntity> entities = paymentDao.findAll();
		List<Payment> payments = new ArrayList<Payment>();
		if (entities!=null) {
			for(PaymentEntity entity : entities) {
				payments.add(PaymentTransformer.transformPaymentEntity(entity));
			}
		}
		response.setData(payments);
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_GETTING PAYMENT");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}

	@Override
	public Response<Payment> getPayment(Integer pId) {
		Response<Payment> response = new Response<>();
		try {
		Optional<PaymentEntity> opEntity = paymentDao.findById(pId);
		
		if (opEntity.isPresent()) {
			response.setData(PaymentTransformer.transformPaymentEntity(opEntity.get()));
		}
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_GETTING PAYMENT");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}

	@Override
	public Response<Boolean> deletePayment(Integer pId) {
		Response<Boolean> response = new Response<>();
		try {
		paymentDao.deleteById(pId);
		response.setData(true);
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_DELETING PAYMENT");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}

}
