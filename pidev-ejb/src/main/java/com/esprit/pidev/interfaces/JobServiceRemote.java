package com.esprit.pidev.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.entity.Job;


@Remote
public interface JobServiceRemote {
	
 
	
	public int ajouterJob(Job j);
	public void affecterJobAVolunteer(int userID,int jobID);
	public List<Job>getJobByServieActivité(String secteur);
	public List<Job>  getJobByTitre(String titre);
	public List<Job> findAllJobs();
	public void deleteJobById(int jibId);
	public void updateJob(Job job);
	public List<Job> findBydateDebut(Date dateD);
	
	 public  void sendMessage(String emailaddress, String subject, String body);

}
