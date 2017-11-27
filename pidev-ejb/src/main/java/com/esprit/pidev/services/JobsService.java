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



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;





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
	
			
			 System.out.print(titre);
		     Query query = em.createQuery("Select  a From Job a where a.titre like :titre  ");
				query.setParameter("titre", "%"+titre+"%");
				
						return query.getResultList();
													  }
	@Override
	public List<Job> findAllJobs() {
		 List<Job> query = em.createQuery("Select e from Job e ", Job.class).getResultList();
		  return query;
		
	}
	@Override
	public boolean deleteJobById(int jibId) {

		Job j = em.find(Job.class, jibId);
		em.remove(j);
		return true ;
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
	
	
	public Job FindByJobById(int id) {
		Job job = em.find(Job.class, id);
		
		
		return job;
	}
	@Override
	public void sendSmS() {
		// TODO Auto-generated method stub
		String myURL="https://rest.nexmo.com/sms/json?api_key=3d9c32a3&api_secret=cea66b40a461623e&to=216"+
	            "28440610"+"&from=InsuranceApp&text=+We+successfuly+received+you+Accident+Statement";
	    System.out.println(myURL);
		    StringBuilder sb = new StringBuilder();
		    URLConnection urlConn = null;
		    InputStreamReader in = null;
		    try {
		        URL url = new URL(myURL);
		        urlConn = url.openConnection();
		        if (urlConn != null)
		            urlConn.setReadTimeout(60 * 1000);
		        if (urlConn != null && urlConn.getInputStream() != null) {
		            in = new InputStreamReader(urlConn.getInputStream(),
		                    Charset.defaultCharset());
		            BufferedReader bufferedReader = new BufferedReader(in);
		            if (bufferedReader != null) {
		                int cp;
		                while ((cp = bufferedReader.read()) != -1) {
		                    sb.append((char) cp);
		                }
		                bufferedReader.close();
		            }
		        }
		        in.close();
		    } catch (Exception e) {
		        throw new RuntimeException("Exception while calling URL:"+ myURL, e);
		    }
			
		
	}

}
