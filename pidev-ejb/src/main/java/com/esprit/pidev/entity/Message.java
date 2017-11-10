package com.esprit.pidev.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {

	   

	private int id;
	private Date Date;
	private String Content;
	private static final long serialVersionUID = 1L;

	private Topic topic;
	private Users users;
	
	
	@ManyToOne
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Message() {
		super();
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdMessage() {
		return this.id;
	}

	public void setIdMessage(int idMessage) {
		this.id = idMessage;
	}   
	public Date getDate() {
		return this.Date;
	}

	public void setDate(Date Date) {
		this.Date = Date;
	}   
	public String getContent() {
		return this.Content;
	}

	public void setContent(String Content) {
		this.Content = Content;
	}
	@ManyToOne
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
   
}
