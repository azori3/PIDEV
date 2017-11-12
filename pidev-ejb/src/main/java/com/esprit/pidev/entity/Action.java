package com.esprit.pidev.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Action
 *
 */
@Entity

public class Action implements Serializable {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "id") 
	    private Integer id;
	private String adresseMapAction;
	private String discriptionAction;
	private Date dateDebutAction;
	private Date dateFinAction;
	private String titreAction;
	private String imageAction;
	
	@ManyToMany(mappedBy="actions")
	private List<Users> users;
	
	
	

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	@Transient
	private static final long serialVersionUID = 1L;
	
	
	@OneToMany(mappedBy = "action")
	private List<Rating> ratings;

	
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Action() {
		super();
	}

	public int getIdAction() {
		return this.id;
	}

	public void setIdAction(int idAction) {
		this.id = idAction;
	}

	public String getAdresseMapAction() {
		return this.adresseMapAction;
	}

	public void setAdresseMapAction(String adresseMapAction) {
		this.adresseMapAction = adresseMapAction;
	}

	public String getDiscriptionAction() {
		return this.discriptionAction;
	}

	public void setDiscriptionAction(String discriptionAction) {
		this.discriptionAction = discriptionAction;
	}

	public Date getDateDebutAction() {
		return this.dateDebutAction;
	}

	public void setDateDebutAction(Date dateDebutAction) {
		this.dateDebutAction = dateDebutAction;
	}

	public Date getDateFinAction() {
		return this.dateFinAction;
	}

	public void setDateFinAction(Date dateFinAction) {
		this.dateFinAction = dateFinAction;
	}

	public String getTitreAction() {
		return this.titreAction;
	}

	public void setTitreAction(String titreAction) {
		this.titreAction = titreAction;
	}

	public String getImageAction() {
		return this.imageAction;
	}

	public void setImageAction(String imageAction) {
		this.imageAction = imageAction;
	}

}
