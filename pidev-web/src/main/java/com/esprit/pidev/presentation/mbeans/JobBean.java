package com.esprit.pidev.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;


import com.esprit.pidev.entity.Contrat;
import com.esprit.pidev.entity.Job;
import com.esprit.pidev.entity.SecteurActivite;
import com.esprit.pidev.entity.Signalisation;
import com.esprit.pidev.services.JobsService;
import com.esprit.pidev.services.SignalisationService;
import com.esprit.pidev.util.EmailSender;





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
	private String infosCompl;
	private String indexationJob;
	
	private Contrat typeContrat;
	private String EmailJob;
	private SecteurActivite servActivite;
	private String contacter;
	private String recevoirCv;
	private Job j;
	
	private String Rechercher;
	
	private  Job job;
	
	
	 
	public String getEmailJob() {
		return EmailJob;
	}
	public void setEmailJob(String emailJob) {
		EmailJob = emailJob;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
    public List<Job> completeTheme(String query) {
        List<Job> allThemes = jobs;
        System.out.println("zekfmlf"+jobs.toString());
        List<Job> filteredThemes = new ArrayList<Job>();
         
        for (int i = 0; i < allThemes.size(); i++) {
            Job skin = allThemes.get(i);
            if(skin.getTitre().toLowerCase().startsWith(query)) {
                filteredThemes.add(skin);
            }
        }
         
        return filteredThemes;
    }
	
	public List<String> completeText(String query) {
	        List<String> results = new ArrayList<String>();
	        for(int i = 0; i < 10; i++) {
	            results.add(query + i);
	        }
	         
	        return results;
	    }
    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }


	public String getRechercher() {
		return Rechercher;
	}

	public void setRechercher(String rechercher) {
		Rechercher = rechercher;
	}

	public Job getJ() {
		return j;
	}

	public void setJ(Job j) {
		this.j = j;
	}

	private List<Job> jobs;
	
	private  int jobIdToBeView;
	
	////
	private String emailaddress;
	private String subject;
	private String body;
	
	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@EJB
	JobsService jobService;  
	

	

	
	@EJB
	EmailSender emailsender;
	
	

	
	

	public int getJobIdToBeView() {
	
		return jobIdToBeView;
	}
	
	public String GoToNextView2() 
	{	
		System.out.println("teeeeeeeeeeeeeest");

		
		String navTo="";
		
		navTo="/pages/VueRecherche?faces-redirect=true";
		return navTo;
		
	}

	
	public String GoToNextView(Job e) 
	{	System.out.println(e.getTitre()+"teeeeeeeeeeeeeest");

		j=e;
		String navTo="";
		navTo="/pages/ViewOffre";
		return navTo;
		
	}



	@PostConstruct
	public void init()
	{
		 
		    
		    
		        
		  jobs = new ArrayList<>();
		  jobs = jobService.findAllJobs();
		 
	}
	
	  
	 public List<Job> getJobs() {
		 jobs = jobService.findAllJobs();
		return jobs;
	}


	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}


	public String getIndexationJob() {
		return indexationJob;
	}
	 

	public String getContacter() {
		return contacter;
	}


	public void setContacter(String contacter) {
		this.contacter = contacter;
	}


	public void setIndexationJob(String indexationJob) {
		this.indexationJob = indexationJob;
	}

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
	 public void submit() {
	        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Correct", "Correct");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	public void addemploye()
	
	
	{		
			jobService.ajouterJob(new Job(titre, contenutJob, profil, nbrPOste, dateDebJob, duréeJob, finDePublication, adresseJob, infosCompl, indexationJob, typeContrat, servActivite, contacter, recevoirCv,EmailJob));
		
	}
	public void envoyerMaile()
	{	
		System.out.println("aaaaaaaaaaammpa");
		emailsender.SendMail();
	
	}
	public JobsService getJobService() {
		return jobService;
	}

	



	public void setJobService(JobsService jobService) {
		this.jobService = jobService;
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

}
