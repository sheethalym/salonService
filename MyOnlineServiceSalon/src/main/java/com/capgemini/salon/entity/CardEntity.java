package com.capgemini.salon.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "card")
public class CardEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "cardName")
	String cardName;
	@Column(name = "cardNumber")
	String cardNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	LocalDate expiryDate;
	@Column(name = "bankName")
	String bankName;
	
	@OneToMany(mappedBy = "cardEntity")
	private List<PaymentEntity> paymentEntity;
	
	public List<PaymentEntity> getPaymentEntity() {
		return paymentEntity;
	}
	public void setPaymentEntity(List<PaymentEntity> paymentEntity) {
		this.paymentEntity = paymentEntity;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		return "CardEntity [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", expiryDate="
				+ expiryDate + ", bankName=" + bankName + "]";
	}

	
}
