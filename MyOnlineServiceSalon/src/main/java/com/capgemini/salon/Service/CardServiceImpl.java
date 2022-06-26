package com.capgemini.salon.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.payment.domain.AppError;
import com.capgemini.payment.domain.Card;
import com.capgemini.payment.domain.Response;
import com.capgemini.salon.dao.CardDao;
import com.capgemini.salon.entity.CardEntity;
import com.capgemini.transformer.CardTransformer;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDao cardDao;

	@Override
	public Response<Card> addCard(Card card) {
		Response<Card> response = new Response<Card>();
		System.out.println("inside service");
		try {
			CardEntity entity=cardDao.findByCardName(card.getCardName());
			if(entity!=null) {
				AppError error = new AppError();
				error.setCode("ERR_ADD_CARD");
				error.setMessage("card already exists"+ card.getCardName());
				response.setError(error);
			}else {
				entity = CardTransformer.transformCard(card);
				cardDao.save(entity);
				Card newCard = CardTransformer.transformCardEntity(entity);
				response.setData(newCard);
			}

		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_ADD_CARD");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}

	@Override
	public Response<Card> updateCard(Card card) {
		Response<Card> response = new Response();

		try {
			CardEntity entity =CardTransformer.transformCard(card);
			cardDao.save(entity);

			Card newCard = CardTransformer.transformCardEntity(entity);
			response.setData(card);
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_UPDATING_CARD");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}

	@Override
	public Response<List<Card>> getAllCard() {

		Response<List<Card>> response = new Response();

		try {
			List<CardEntity> entities = cardDao.findAll();
			List<Card> cards = new ArrayList<>();
			if (entities != null) {
				for (CardEntity entity : entities) {
					Card newCard = CardTransformer.transformCardEntity(entity);
					cards.add(newCard);
				}
			}
			response.setData(cards);
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_GETTING_CARDS");
			error.setMessage(e.getMessage());
			response.setError(error);
		}
		return response;
	}

	@Override
	public Response<Card> getCard(Integer cId) {
		Response<Card> response = new Response();
		System.out.println("inside getcard service");
		try {
			Optional<CardEntity> opEntity = cardDao.findById(cId);

			if (opEntity.isPresent()) {
				CardEntity entity = opEntity.get();
				Card newCard = CardTransformer.transformCardEntity(entity);
				response.setData(newCard);
			}
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_GETTING_CARD");
			error.setMessage("No category found for id" + cId);
			response.setError(error);
		}
		return response;
	}
	
	public Response<Card> getCardByName(String cName) {
		Response<Card> response = new Response();

		try {
			CardEntity entity = cardDao.findByCardName(cName);

			if (entity!=null) {
				Card newCard = CardTransformer.transformCardEntity(entity);
				response.setData(newCard);
			}
		} catch (Exception e) {
			AppError error = new AppError();
			error.setCode("ERR_GETTING_CARD");
			error.setMessage("No category found with name" + cName);
			response.setError(error);
		}
		return response;
	}

}
