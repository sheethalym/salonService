package com.capgemini.salon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.salon.entity.PaymentEntity;

@Repository
public interface PaymentDao extends JpaRepository<PaymentEntity, Integer> {

}
