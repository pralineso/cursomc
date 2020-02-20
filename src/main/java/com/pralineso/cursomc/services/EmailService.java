package com.pralineso.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.pralineso.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
