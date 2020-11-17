package com.ma.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ma.model.CreditCard;

public interface  CreditCardRepository extends JpaRepository<CreditCard, Long> {

}
