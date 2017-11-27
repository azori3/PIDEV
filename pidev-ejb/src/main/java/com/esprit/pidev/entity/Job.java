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

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Users users;
	private String titre;
	private String contenutJob;
	private String profil;
	private int nbrPOste;
	private Date dateDebJob;
	private String duréeJob;
	private Date finDePublication;
	private String adresseJob;
	private String infosCompl;
	private String indexationJob;
	private Contrat typeContrat;
	private SecteurActivite servActivite;
	private String contacter;
	private String recevoirCv;
	
	private String EmailJob;
	private Signalisation signalisation;
	
	
	
	
	
	public String getEmailJob() {
		return EmailJob;
	}

	public void setEmailJob(String emailJob) {
		EmailJob = emailJob;
	}

	@OneToOne(mappedBy="job")
	public Signalisation getSignalisation() {
		return signalisation;
	}

	public void setSignalisation(Signalisation signalisation) {
		this.signalisation = signalisation;
	}



	 public Job( String titre, String contenutJob, String profil, int nbrPOste, Date dateDebJob,
			String duréeJob, Date finDePublication, String adresseJob, String infosCompl, String indexationJob,
			Contrat typeContrat, SecteurActivite servActivite, String contacter, String recevoirCv,String email) {
		super();
	
		this.titre = titre;
		this.contenutJob = contenutJob;
		this.profil = profil;
		this.nbrPOste = nbrPOste;
		this.dateDebJob = dateDebJob;
		this.duréeJob = duréeJob;
		this.finDePublication = finDePublication;
		this.adresseJob = adresseJob;
		this.infosCompl = infosCompl;
		this.indexationJob = indexationJob;
		this.typeContrat = typeContrat;
		this.servActivite = servActivite;
		this.contacter = contacter;
		this.recevoirCv = recevoirCv;
		this.EmailJob=email;
	}

	public Job() {
		super();
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenutJob() {
		return contenutJob;
	}

	public void setContenutJob(String contenutJob) {
		this.contenutJob = contenutJob;
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

	public Date getDateDebJob() {
		return dateDebJob;
	}

	public void setDateDebJob(Date dateDebJob) {
		this.dateDebJob = dateDebJob;
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

	public String getAdresseJob() {
		return adresseJob;
	}

	public void setAdresseJob(String adresseJob) {
		this.adresseJob = adresseJob;
	}


	public String getIndexationJob() {
		return indexationJob;
	}

	public void setIndexationJob(String indexationJob) {
		this.indexationJob = indexationJob;
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

	public String getContacter() {
		return contacter;
	}

	public void setContacter(String contacter) {
		this.contacter = contacter;
	}


	public String getInfosCompl() {
		return infosCompl;
	}

	public void setInfosCompl(String infosCompl) {
		this.infosCompl = infosCompl;
	}

	public String getRecevoirCv() {
		return recevoirCv;
	}

	public void setRecevoirCv(String recevoirCv) {
		this.recevoirCv = recevoirCv;
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
