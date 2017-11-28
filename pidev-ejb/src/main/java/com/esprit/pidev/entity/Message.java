package com.esprit.pidev.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {

	   

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMessage;
	@Column
	private String contenu;
	@Column
	@Temporal(TemporalType.DATE)
	private Date datePost;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateEdit;
	@Column
	private int nbLike;
	@JsonIgnore
	@OneToMany(mappedBy="idmessage",cascade={CascadeType.PERSIST,CascadeType.ALL},fetch=FetchType.LAZY,orphanRemoval=true)
	private List<Reponse> Responses;

	
	@ManyToOne
	@JoinColumn(name="idTopic")
	private Topic topic;
	@ManyToOne
	@JoinColumn(name="idPosteur")
	private Users idPosteur;
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDatePost() {
		return datePost;
	}
	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}
	public Date getDateEdit() {
		return dateEdit;
	}
	public void setDateEdit(Date dateEdit) {
		this.dateEdit = dateEdit;
	}
	public int getNbLike() {
		return nbLike;
	}
	public void setNbLike(int nbLike) {
		this.nbLike = nbLike;
	}
	@JsonIgnore
	public List<Reponse> getResponses() {
		return Responses;
	}
	public void setResponses(List<Reponse> responses) {
		Responses = responses;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Users getIdPosteur() {
		return idPosteur;
	}
	public void setIdPosteur(Users idPosteur) {
		this.idPosteur = idPosteur;
	}
	
	
	
	
	
	
   
}
