package com.ma.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ma.controller.CreditCardController;
import com.ma.model.CreditCard;


@Path("/Credit_Card")
@Produces({ MediaType.APPLICATION_XML , MediaType.APPLICATION_JSON })
public class CreditCardResource {
	
	CreditCardController creditCardController = new CreditCardController();
	
	//Constructeur par defaut
		public CreditCardResource() {}
		
		//Methode validate()
		@GET
		@Path("/verify/{number}")
		public String validate(@PathParam("number") String number) {
			
			int[] ints = new int[number.length()];
			for (int i = 0; i < number.length(); i++) {
				ints[i] = Integer.parseInt(number.substring(i, i + 1));
			}
			for (int i = ints.length - 2; i >= 0; i = i - 2) {
				int j = ints[i];
				j = j * 2;
				if (j > 9) {
					j = j % 10 + 1;
				}
				ints[i] = j;
			}
			int sum = 0;
			for (int i = 0; i < ints.length; i++) {
				sum += ints[i];
			}
			if (sum % 10 == 0) {	
				return "Card valid ";
			} else {
				return "Card invalid";
			}
			 
		}
		
		//Methode ajouter
		@POST
		@Path("/addCreditCard")
		public CreditCard createCard(CreditCard card) {
			return creditCardController.createCard(card);
			
		}
		
		
		//Methode Modifier
		@Path("/updateCreditCard/{id}") 
		public void updateCreditCard(@PathParam("id") String number,String expiryDate,Integer controlNumber,String type) {
			
			for (CreditCard card : creditCardController.getAllCards()) {
	            if (card.getNumber().equals(number)) {
	            	card.setExpiryDate(expiryDate);
	            	card.setControlNumber(controlNumber);
	            	card.setType(type);
	            }
	            
	            creditCardController.getAllCards().add(card);
	        }
		}
		
		//Methode Supprimer
		@DELETE 
	    @Path("/removeCreditCard/{id}")
		public void deleteCard(CreditCard card) {
			creditCardController.deleteUser(card);
			
		}
		
		//Methode Afficher tous
		@POST
		@Path("/CreditCards")
		public List<CreditCard> getAllCards() {
			List<CreditCard> cards = creditCardController.getAllCards();
			return cards;
		}

}
