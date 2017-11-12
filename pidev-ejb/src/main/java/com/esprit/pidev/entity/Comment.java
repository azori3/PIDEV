package com.esprit.pidev.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity

public class Comment implements Serializable {

	private int id;
	private Date dateComment;
	private String Content;
	private static final long serialVersionUID = 1L;

	private Users users;
	
	public Comment() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdComment() {
		return this.id;
	}

	public void setIdComment(int idComment) {
		this.id = idComment;
	}

	public Date getDateComment() {
		return this.dateComment;
	}

	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
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
