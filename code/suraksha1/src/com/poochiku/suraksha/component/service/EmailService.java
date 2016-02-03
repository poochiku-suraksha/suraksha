package com.poochiku.suraksha.component.service;

import com.poochiku.suraksha.component.helper.Email;

public class EmailService implements Runnable
{

	String to, subject, text, html;

	public EmailService(String to, String subject, String text, String html)
	{
		this.html = html;
		this.subject = subject;
		this.text = text;
		this.to = to;

	}
	
	public void send()
	{
		Thread t = new Thread(this);
        t.start();
	}

	@Override
	public void run()
	{
		Email email = new Email();
		email.SendHTMLEmail(to, subject, text, html);

	}

}
