package com.ma.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ma.dao.CreditCardDAO;
import com.ma.model.CreditCard;

public class CreditCardController {
	
	CreditCardDAO creditCardDAO = new CreditCardDAO();

	public List<CreditCard> getAllCards() {
		List<CreditCard> creditCardList = creditCardDAO.findAll();
		return creditCardList;
	}

	public CreditCard getCardId(Long id) {
		CreditCard card = creditCardDAO.findOne(id);
		return card;
	}

	public CreditCard createCard(CreditCard card) {
		CreditCard cardRes = creditCardDAO.save(card);
		return cardRes;
	}

	public ResponseEntity<CreditCard> updateCard(Long id,CreditCard card) {
		CreditCard card1=creditCardDAO.findOne(id);
		if(card==null) {
			return ResponseEntity.notFound().build();
		}
		
		card1.setNumber(card.getNumber());
		card1.setControlNumber(card.getControlNumber());
		card1.setExpiryDate(card.getExpiryDate());
		card1.setType(card.getType());
		
		
		CreditCard updateCard=creditCardDAO.save(card1);
		return ResponseEntity.ok().body(updateCard);
	}

	public void deleteUser(CreditCard card) {
		  creditCardDAO.delete(card);
		
	}


}
