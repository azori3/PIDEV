package com.esprit.pidev.presentation.mbeans;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import org.primefaces.event.FlowEvent;


import com.esprit.pidev.entity.Contrat;
import com.esprit.pidev.entity.Job;
import com.esprit.pidev.entity.SecteurActivite;
import com.esprit.pidev.services.JobsService;


@ManagedBean
@ViewScoped
public class JobBean implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JobBean() {
						}
	
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
	@EJB
	JobsService jobService;
	
	 private boolean skip ;
	 public boolean isSkip() {
	        return skip;
	    }
	 
	    public void setSkip(boolean skip) {
	        this.skip = skip;
	    }
	     
	    public String onFlowProcess(FlowEvent event) {
	        
	            return event.getNewStep();
	       
	    }
	


	public Date getCurrentDate() {
		 Calendar currentDate = Calendar.getInstance();
		   
		    return currentDate.getTime();
	}
	public Date getMaxDate() {
		Calendar currentDate = Calendar.getInstance();
        currentDate.add(Calendar.DAY_OF_MONTH, 30);
        return currentDate.getTime(); 
		
	}
	public void addemploye()
	
	
	{	
			System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

			jobService.ajouterJob(new Job(titre,contenutJob,profil,nbrPOste));
		
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

	public String getInfosCompl() {
		return InfosCompl;
	}

	public void setInfosCompl(String infosCompl) {
		InfosCompl = infosCompl;
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
	
	
	
	
	
	
}
