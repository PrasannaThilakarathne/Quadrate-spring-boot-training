package com.example.contactform.service;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.example.contactform.model.MailProperties;

public class SESService implements SendingMailService {

	private final MailProperties mailproperties;
	
	SESService(MailProperties mailProperties){
		this.mailproperties= mailProperties;
	}
	
	@Override
	public boolean sendMail(String subject, String body) {
        try {
            Properties props = System.getProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.port", mailproperties.getSmtp().getPort());
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(mailproperties.getFrom(), mailproperties.getFromName()));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mailproperties.getTo()));
            msg.setSubject(subject);
            msg.setContent(body, "text/html");

            Transport transport = session.getTransport();
            transport.connect(mailproperties.getSmtp().getHost(), mailproperties.getSmtp().getUsername(), mailproperties.getSmtp().getPassword());
            transport.sendMessage(msg, msg.getAllRecipients());
            return true;
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return false;
    }

}
