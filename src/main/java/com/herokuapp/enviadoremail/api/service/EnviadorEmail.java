package com.herokuapp.enviadoremail.api.service;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;

import com.herokuapp.enviadoremail.api.model.Email;
import com.herokuapp.enviadoremail.api.model.Usuario;

@Service
public class EnviadorEmail implements Serializable{

	private static final long serialVersionUID = 4309159621526896696L;
	private Usuario remetente;

	private Properties properties;
	private Session session;
	
	public void enviarEmail(Email email) throws Exception{
		try {
			this.remetente = email.getUsuario();
			MimeMessage message = new MimeMessage(getSession());
			message.setFrom(new InternetAddress(remetente.getEmail()));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getDestinatario()));
			message.setSubject(email.getAssunto(), "utf-8");
			
			BodyPart conteudo = new MimeBodyPart();
			conteudo.setContent(email.getCorpo(), "text/html; charset=\"utf-8\"");
			conteudo.setHeader("Content-Type","text/html; charset=\"utf-8\"");
			
			Multipart conteudoEAnexos = new MimeMultipart();
			conteudoEAnexos.addBodyPart(conteudo);
			
			message.setContent(conteudoEAnexos);
			Transport.send(message);
		} catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public Properties getProperties(){
		if(properties == null){
			properties = new Properties();
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.port", "465");
		}
		return properties;
	}

	public Session getSession() {
		session = Session.getDefaultInstance(getProperties(),
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								remetente.getEmail(), remetente.getSenha());
					}
				});
		return session;
	}
}
