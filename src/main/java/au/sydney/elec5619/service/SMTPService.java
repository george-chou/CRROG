package au.sydney.elec5619.service;

import java.util.Properties;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl; 


public class SMTPService extends Thread
{
		
	@Autowired
	private JavaMailSender mailSender;
	
	private String mailto;
	private String vcode;
	
	private static final String textBody = "Welcome to join us, your verify code is ";
	
	public SMTPService(String mailto) 
	{
		super();
		this.mailto = mailto;
		this.vcode = randVerCode();
		this.mailSender = javaMailSender();
	}
	
	@Override
	public void run()
	{
		try 
		{
			sendEmail();
		} 
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
	}
	
	public String getVCode()
	{
		return vcode;
	}
	
    @Bean
    private JavaMailSender javaMailSender() 
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        Properties mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", true);
        mailProperties.put("mail.smtp.starttls.enable", false);
        mailSender.setJavaMailProperties(mailProperties);
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(25);
        mailSender.setProtocol("smtp");
        mailSender.setUsername("username");
        mailSender.setPassword("password");
        return mailSender;
    }

	private void sendEmail() throws MessagingException 
	{
		SimpleMailMessage message = new SimpleMailMessage();		
	    message.setFrom("username@qq.com");
	    message.setTo(mailto);
	    message.setSubject("DO NOT REPLY");
	    message.setText(textBody + vcode);

	    mailSender.send(message);
	}
	
	private String randVerCode()
	{
		String thousands = String.valueOf((int)(Math.random() * 10));
		String hundreds = String.valueOf((int)(Math.random() * 10));
		String tens = String.valueOf((int)(Math.random() * 10));
		String ones = String.valueOf((int)(Math.random() * 10));

		return thousands + hundreds + tens + ones;
	}
	
}
