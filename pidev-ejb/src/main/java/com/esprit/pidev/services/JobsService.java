package com.esprit.pidev.services;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import com.esprit.pidev.entity.Job;
import com.esprit.pidev.entity.Users;
import com.esprit.pidev.interfaces.*;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;





@Stateless
@LocalBean
public class JobsService implements JobServiceRemote {

	
	@PersistenceContext
	private EntityManager em;
	@Override
	public int ajouterJob(Job j) {

		em.persist(j);
		return j.getId();
		
	}
	@Override
	public void affecterJobAVolunteer(int userID,int jobID) {

		Users usr = em.find(Users.class,jobID);
		Job job = em.find(Job.class, jobID);
		usr.setJob(job);
	}
	@Override
	public List<Job> getJobByServieActivité(String secteur) {
		
		return null;
	}
	@Override
	public List<Job>  getJobByTitre(String titre) {

		
		List<Job> query = em.createQuery("Select e from Job e "
			    + "where e.titre=:titre",Job.class).getResultList();
				((Query) query).setParameter("titre",titre);
				
				
				
				return query;
	}
	@Override
	public List<Job> findAllJobs() {
		 List<Job> query = em.createQuery("Select e from Job e ", Job.class).getResultList();
		  return query;
		
	}
	@Override
	public void deleteJobById(int jibId) {

		Job j = em.find(Job.class, jibId);
		em.remove(j);
	}
	@Override
	public void updateJob(Job job) {

		em.merge(job);
	}
	@Override
	public List<Job> findBydateDebut(Date dateD) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	 public  void sendMessage(String emailaddress, String subject, String body) {
	        try {
	           Properties props = new Properties();
	           props.setProperty("mail.smtp.port", "25");
	           props.setProperty("hichem.alouis123@gmail.com", "tunis123456");

	           Session mailSession = Session.getDefaultInstance(props, null);
	           Transport transport = mailSession.getTransport();

	           MimeMessage message = new MimeMessage(mailSession);
	           message.setSubject("Testing javamail plain");
	           message.setContent("This is a test", "text/plain");
	           message.addRecipient(Message.RecipientType.TO, new InternetAddress("ali.methnani@esprit.tn"));

	           transport.connect();
	           transport.sendMessage(message,
	                   message.getRecipients(Message.RecipientType.TO));
	           transport.close();
	        } catch (MessagingException ex) {
	           ex.printStackTrace();
	           System.out.println("failed");
	        }
	

	
	
	}

}
