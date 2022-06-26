package com.capgemini.salon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.salon.entity.CardEntity;

@Repository
public interface CardDao extends JpaRepository<CardEntity, Integer>{
	CardEntity findByCardName(String cardName);

}
