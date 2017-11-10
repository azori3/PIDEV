package com.esprit.pidev.entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	   

	private int id;
	private String ContentCat;
	private static final long serialVersionUID = 1L;

	private Users users;
	
	
	
	@ManyToOne
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Category() {
		super();
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCategory() {
		return this.id;
	}

	public void setIdCategory(int idCategory) {
		this.id = idCategory;
	}   
	public String getContentCat() {
		return this.ContentCat;
	}

	public void setContentCat(String ContentCat) {
		this.ContentCat = ContentCat;
	}
   
}
