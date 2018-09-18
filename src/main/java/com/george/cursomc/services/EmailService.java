package com.george.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.george.cursomc.domain.Pedido;

public interface EmailService {
	public void sendOrderConfirmationEmail(Pedido obj);
	
	public void sendMail(SimpleMailMessage sm);
}
