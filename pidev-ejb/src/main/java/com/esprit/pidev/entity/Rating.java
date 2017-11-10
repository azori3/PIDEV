package com.esprit.pidev.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rating implements Serializable {
	
	private RatingPk ratingPk;
	private int nbEtoile;
	private String description;
	private Action action;
	private Users users;

	@EmbeddedId
	public RatingPk getRatingPk() {
		return ratingPk;
	}

	public void setRatingPk(RatingPk ratingPk) {
		this.ratingPk = ratingPk;
	}

	public int getNbEtoile() {
		return nbEtoile;
	}

	public void setNbEtoile(int nbEtoile) {
		this.nbEtoile = nbEtoile;
	}

	@ManyToOne
	@JoinColumn(name = "idAction", referencedColumnName = "id", insertable = false, updatable = false)
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
