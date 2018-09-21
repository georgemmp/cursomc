package com.george.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.george.cursomc.domain.Cliente;
import com.george.cursomc.domain.Pedido;

public interface EmailService {
	public void sendOrderConfirmationEmail(Pedido obj);
	
	public void sendMail(SimpleMailMessage sm);
	
	public void sendOrderConfirmationHtmlEmail(Pedido obj);
	
	public void sendHtmlEmail(MimeMessage msg);
	
	public void sendNewPasswordEmail(Cliente cliente, String newPassword);
}
