package com.esprit.pidev.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RatingPk implements Serializable {

	private int idAction;
	private int idUser;

	public int getIdAction() {
		return idAction;
	}

	public void setIdAction(int idAction) {
		this.idAction = idAction;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAction;
		result = prime * result + idUser;
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
		RatingPk other = (RatingPk) obj;
		if (idAction != other.idAction)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}

	
	
}
