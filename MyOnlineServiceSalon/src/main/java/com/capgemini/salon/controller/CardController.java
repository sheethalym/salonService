package com.capgemini.salon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.payment.domain.Card;
import com.capgemini.payment.domain.Response;
import com.capgemini.salon.Service.CardService;




@RestController
@RequestMapping("/cards")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@PostMapping(value="/savecard", consumes="application/json", produces="application/json")
	public Response<Card> addCard(@RequestBody Card card){
		System.out.println("inside controller");
		System.out.println(card);
		return cardService.addCard(card);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<Card> updateCard(@RequestBody Card card){
		System.out.println("inside update controller");
		return cardService.updateCard(card);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response<List<Card>> getAllCard(){
		
		return cardService.getAllCard();
	}
	
	@GetMapping(value="/{cId}", consumes="application/json", produces="application/json")
	public Response<Card> getCard(@PathVariable("cId") Integer cId){
		System.out.println("inside getcard controller");
		return cardService.getCard(cId);
	}
}
