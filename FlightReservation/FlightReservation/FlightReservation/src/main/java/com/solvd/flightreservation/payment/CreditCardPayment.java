package com.solvd.flightreservation.payment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.flightreservation.exceptions.*;
import com.solvd.flightreservation.interfaces.Payment;
import com.solvd.flightreservation.model.TicketGenerator;

public class CreditCardPayment implements Payment {

	private long cardNumber;
	private String cardholderName;
	private double amount;

	private static final Logger LOGGER = LogManager.getLogger(CreditCardPayment.class);

	public CreditCardPayment(long cardNumber, String cardholderName, double amount) {
		this.cardNumber = cardNumber;
		this.cardholderName = cardholderName;
		this.amount = amount;
	}

	public CreditCardPayment() {

	}

	@Override
	public void creditCardPayment(double amount) {
		if (amount > 0) {
			LOGGER.info("Credit number ending with this number was used " + getCardNumber() + getCardholderName()
					+ getAmount());

		} else {
			throw new InvalidPaymentException("Insufficient amount .");
		}

	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public static boolean isCardNumberValid(long cardNumber) {

		int cardNumberLength = Long.toString(cardNumber).length();
		return cardNumberLength == 16;
	}

	public static void processPayment(long cardNumber,TicketGenerator ticket) {
		if(isCardNumberValid( cardNumber)) {
			ticket.setStatus("Confirmed");
		} else {
            // logging error
            LOGGER.error("Invalid credit card number");
            throw new CardException("Invalid credit card number");
        }
	}

}