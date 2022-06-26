package com.capgemini.salon.Service;

import java.util.List;

import com.capgemini.payment.domain.Card;
import com.capgemini.payment.domain.Response;

public interface CardService {

	public Response<Card> addCard(Card card);

	public Response<Card> updateCard(Card card);

	public Response<List<Card>> getAllCard();

	public Response<Card> getCard(Integer cId);
	
	public Response<Card> getCardByName(String cName);

}
