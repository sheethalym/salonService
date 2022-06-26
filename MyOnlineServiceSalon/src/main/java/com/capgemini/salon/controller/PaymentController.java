
package com.capgemini.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.payment.domain.Card;
import com.capgemini.payment.domain.Payment;
import com.capgemini.payment.domain.Response;
import com.capgemini.salon.Service.CardService;
import com.capgemini.salon.Service.PaymentService;




@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Payment> addPayments(@RequestBody Payment payment){
		System.out.println("starting of add controller");
		return paymentService.addPayment(payment);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Payment> updatePayments(@RequestBody Payment payment){
		return paymentService.updatePayment(payment);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<List<Payment>> getAllPayments(){
		return paymentService.getAllPayments();
	}
	
	@GetMapping(value="/{paymentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Payment> getPayments(@PathVariable("paymentId") Integer pId){
		return paymentService.getPayment(pId);
	}
	
	@DeleteMapping(value="/{paymentId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Boolean> deletePayments(@PathVariable("paymentId") Integer pId){
		return paymentService.deletePayment(pId);
	}
}

