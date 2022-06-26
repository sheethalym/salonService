package com.capgemini.transformer;

import com.capgemini.payment.domain.Card;
import com.capgemini.salon.entity.CardEntity;

public class CardTransformer {
	public static CardEntity transformCard(Card card) {
		if(card !=null) {
			CardEntity entity = new CardEntity();
			entity.setId(card.getId());
			entity.setCardName(card.getCardName());
			entity.setCardNumber(card.getCardNumber());
			entity.setExpiryDate(card.getExpiryDate());
			entity.setBankName(card.getBankName());
			return entity;
		}
		return null;
	}
	
	public static Card transformCardEntity(CardEntity entity) {
		if(entity!=null) {
			Card newCard = new Card();
			newCard.setCardName(entity.getCardName());
			newCard.setCardNumber(entity.getCardNumber());
			newCard.setExpiryDate(entity.getExpiryDate());
			newCard.setBankName(entity.getBankName());
			return newCard;
		}
		return null;
	}
}
