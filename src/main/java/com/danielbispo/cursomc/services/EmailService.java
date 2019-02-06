package com.danielbispo.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.danielbispo.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
