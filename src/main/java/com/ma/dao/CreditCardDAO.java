package com.ma.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.model.CreditCard;
import com.ma.repository.CreditCardRepository;

//@Service
public class CreditCardDAO {
	
	@Autowired
	CreditCardRepository creditCardRepository;
	
	
	//Ajouter
	public CreditCard save(CreditCard card) {
		return creditCardRepository.save(card);
	}
	
	//Afficher tous
	public List<CreditCard> findAll(){
		return creditCardRepository.findAll();
	}
	
	//Chercher par Id
	public CreditCard findOne(Long cardid) {
		return creditCardRepository.findOne(cardid);
	}
	
	
	//Supprimer
	public void delete(CreditCard card) {
		creditCardRepository.delete(card);
	}

}
