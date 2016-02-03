package com.poochiku.suraksha.test;

import com.poochiku.suraksha.component.helper.Email;

public class EmailTest
{

	public static void main(String args[])
	{
		Email email = new Email();
		email.SendHTMLEmail("preethamumarani@gmail.com","Welcome Preetham to Suraksha Project","Thanks for supporting us" ,"<h1>Virat Kohli scored a brilliant half century</h1>");
	}
}
