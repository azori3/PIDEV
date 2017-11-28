package com.esprit.pidev.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity

public class SousCategory implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSousCategory;
	@Column
	private String Name;
	
	@ManyToOne
	@JoinColumn(name="idCategory")
	private Category idCategory;
	@JsonIgnore
	@OneToMany(mappedBy="sousCategory",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
	private List<Topic> Topics;
	
	@ManyToOne
	@JoinColumn(name="idUser")
	private Users user;
	
	public int getIdSousCategory() {
		return idSousCategory;
	}
	public void setIdSousCategory(int idSousCategory) {
		this.idSousCategory = idSousCategory;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public Category getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Category idCategory) {
		this.idCategory = idCategory;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@JsonIgnore
	public List<Topic> getTopics() {
		return Topics;
	}
	public void setTopics(List<Topic> topics) {
		Topics = topics;
	}
	@Override
	public String toString() {
		return "SousCategory [idSousCategory=" + idSousCategory + ", Name=" + Name + ", idCategory=" + idCategory
				+ ", Topics=" + Topics + ", user=" + user + "]";
	}
	
	
	
	
	
}
