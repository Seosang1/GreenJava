package mailtest;

import javax.mail.*;

public class NaverAuthentication extends Authenticator {
	PasswordAuthentication passAuth;

	public NaverAuthentication() {
		passAuth = new PasswordAuthentication("gimkeung", "k990113"); 
											// ���̹����̵�, ���̹���й�ȣ
	}
	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
}


