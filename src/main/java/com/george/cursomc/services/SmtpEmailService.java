package com.george.cursomc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractEmailService{
	
	@Autowired
	private MailSender mailSender;
	
	private final static Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	@Override
	public void sendMail(SimpleMailMessage sm) {
		LOG.info("Simulando envio de email...");
		mailSender.send(sm);
		LOG.info("Email enviado");
	}

}
