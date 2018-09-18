package com.george.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockMailService extends AbstractEmailService{
	
	private final static Logger LOG = LoggerFactory.getLogger(MockMailService.class);

	@Override
	public void sendMail(SimpleMailMessage sm) {
		LOG.info("Simulando envio de email...");
		LOG.info(sm.toString());
		LOG.info("Email enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de email HTML...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
	}

}
