package com.esprit.pidev.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Job
 *
 */

@Entity
public class Job implements Serializable {

	
	
	private int id;
	private String titre;
	private String contenutJob;
	private String profil;
	private int nbrPOste;
	private Date dateDebJob;
	private String duréeJob;
	private Date finDePublication;
	private String adresseJob;
	private String InfosCompl;
	
	private Contrat typeContrat;
	private SecteurActivite servActivite;
	
	private String RecevoirCv;
	
	
	
	
	
	

	public Job(String titre, String contenutJob, String profil,int nbrPoste) {
		super();
		this.titre = titre;
		this.contenutJob = contenutJob;
		this.profil = profil;
		this.nbrPOste = nbrPoste;
	}



	public String getContenutJob() {
		return contenutJob;
	}



	public void setContenutJob(String contenutJob) {
		this.contenutJob = contenutJob;
	}



	public Contrat getTypeContrat() {
		return typeContrat;
	}



	public void setTypeContrat(Contrat typeContrat) {
		this.typeContrat = typeContrat;
	}


	
	public SecteurActivite getServActivite() {
		return servActivite;
	}



	public void setServActivite(SecteurActivite servActivite) {
		this.servActivite = servActivite;
	}



	public String getRecevoirCv() {
		return RecevoirCv;
	}



	public void setRecevoirCv(String recevoirCv) {
		RecevoirCv = recevoirCv;
	}

	private static final long serialVersionUID = 1L;

	private Users users;
	
	public Job() {
		super();
	}
	
	

	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getProfil() {
		return profil;
	}



	public void setProfil(String profil) {
		this.profil = profil;
	}



	public int getNbrPOste() {
		return nbrPOste;
	}



	public void setNbrPOste(int nbrPOste) {
		this.nbrPOste = nbrPOste;
	}



	public String getDuréeJob() {
		return duréeJob;
	}



	public void setDuréeJob(String duréeJob) {
		this.duréeJob = duréeJob;
	}



	public Date getFinDePublication() {
		return finDePublication;
	}



	public void setFinDePublication(Date finDePublication) {
		this.finDePublication = finDePublication;
	}



	public String getInfosCompl() {
		return InfosCompl;
	}



	public void setInfosCompl(String infosCompl) {
		InfosCompl = infosCompl;
	}







	public Date getDateDebJob() {
		return this.dateDebJob;
	}

	public void setDateDebJob(Date dateDebJob) {
		this.dateDebJob = dateDebJob;
	}


	public String getAdresseJob() {
		return this.adresseJob;
	}

	public void setAdresseJob(String adresseJob) {
		this.adresseJob = adresseJob;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OneToOne
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
