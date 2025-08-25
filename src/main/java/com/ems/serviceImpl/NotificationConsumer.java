package com.ems.serviceImpl;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ems.config.AppConstant;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class NotificationConsumer {

	@KafkaListener(topics = AppConstant.TOPIC_NAME, groupId = "email_group")
	public void consume(Map<String, Object> event) {

		String employeeID = (String) event.get("employeeID");
		String projectID = (String) event.get("projectID");
		String projectName = (String) event.get("projectName");
		String email = (String) event.get("email");
		String msg = (String) event.get("event");
		sendEmail(email,employeeID,projectID,projectName,msg);

	}
	
	public void sendEmail(String to,String employeeID,String projectID,String projectName,String msg) {
		final String fromEmail = "subhamgupta909@gmail.com";
		final String password = "rtkv budg uqgx oata";
		try {
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");


			javax.mail.Session session = javax.mail.Session.getInstance(props, new javax.mail.Authenticator() {
				protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
					return new javax.mail.PasswordAuthentication(fromEmail, password);
				}
			});

			javax.mail.Message message = new javax.mail.internet.MimeMessage(session);
			message.setFrom(new javax.mail.internet.InternetAddress(fromEmail));
			message.setRecipients(javax.mail.Message.RecipientType.TO, javax.mail.internet.InternetAddress.parse(to));
	        message.setSubject("New Project Assigned");
	        message.setText("You have been assigned to project ID: " + projectID+"and project name is "+projectName+" associated with your employeeID "+employeeID);

			javax.mail.Transport.send(message);
	        System.out.println("Email sent to " + to);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
