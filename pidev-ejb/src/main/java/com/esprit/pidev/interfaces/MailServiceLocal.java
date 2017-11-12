package com.esprit.pidev.interfaces;

import javax.ejb.Local;

@Local
public interface MailServiceLocal {
	void send(String addresses, String topic, String textMessage);
}