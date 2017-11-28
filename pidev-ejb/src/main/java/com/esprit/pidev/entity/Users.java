package com.esprit.pidev.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String mail;
@JsonIgnore
	@ManyToMany
	private List<Action> actions;
@JsonIgnore
	@OneToMany
	private List<Comment> comments;
	private Job job;
	@JsonIgnore
	@OneToMany
	private List<Rating> ratings;
	@JsonIgnore	
	@OneToMany(mappedBy="user")
	private List<SousCategory> SousCategories;
	@JsonIgnore
	@OneToMany(mappedBy="idCreateur")
	private List<Topic> topics;
	@JsonIgnore
	@OneToMany(mappedBy="idPosteur")
	private List<Message> messages;
	@JsonIgnore
	@OneToMany(mappedBy="idUser")
	private List<Reponse> reponses;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@JsonIgnore
	public List<Action> getActions() {
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	@JsonIgnore
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	@JsonIgnore
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	@JsonIgnore
	public List<SousCategory> getSousCategories() {
		return SousCategories;
	}
	public void setSousCategories(List<SousCategory> sousCategories) {
		SousCategories = sousCategories;
	}
	@JsonIgnore
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	@JsonIgnore
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	@JsonIgnore
	public List<Reponse> getReponses() {
		return reponses;
	}
	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	
	
	
}
