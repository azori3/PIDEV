package com.esprit.pidev.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Topic
 *
 */
@Entity
public class Topic implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTopic;
	@Column
	private String sujet;
	@Column
	private String contenu;
	@Column
	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@JsonIgnore
	@OneToMany( mappedBy="topic",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY,orphanRemoval=true)
	private List<Message> Messages;
	
	@ManyToOne
	@JoinColumn(name="idSousCategory")
	private SousCategory sousCategory;
	@ManyToOne
	@JoinColumn(name="idCreateur")
	private Users idCreateur;
	

	public int getIdTopic() {
		return idTopic;
	}
	public void setIdTopic(int idTopic) {
		this.idTopic = idTopic;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public SousCategory getSousCategory() {
		return sousCategory;
	}
	public void setSousCategory(SousCategory sousCategory) {
		this.sousCategory = sousCategory;
	}
	public Users getIdCreateur() {
		return idCreateur;
	}
	public void setIdCreateur(Users idCreateur) {
		this.idCreateur = idCreateur;
	}
	@JsonIgnore
	public List<Message> getMessages() {
		return Messages;
	}
	public void setMessages(List<Message> messages) {
		Messages = messages;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contenu == null) ? 0 : contenu.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((idCreateur == null) ? 0 : idCreateur.hashCode());
		result = prime * result + idTopic;
		result = prime * result + ((sousCategory == null) ? 0 : sousCategory.hashCode());
		result = prime * result + ((sujet == null) ? 0 : sujet.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		if (contenu == null) {
			if (other.contenu != null)
				return false;
		} else if (!contenu.equals(other.contenu))
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (idCreateur == null) {
			if (other.idCreateur != null)
				return false;
		} else if (!idCreateur.equals(other.idCreateur))
			return false;
		if (idTopic != other.idTopic)
			return false;
		if (sousCategory == null) {
			if (other.sousCategory != null)
				return false;
		} else if (!sousCategory.equals(other.sousCategory))
			return false;
		if (sujet == null) {
			if (other.sujet != null)
				return false;
		} else if (!sujet.equals(other.sujet))
			return false;
		return true;
	}
	
	
}
