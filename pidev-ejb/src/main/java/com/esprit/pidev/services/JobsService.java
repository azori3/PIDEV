package com.esprit.pidev.services;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.esprit.pidev.entity.Job;
import com.esprit.pidev.entity.Users;
import com.esprit.pidev.interfaces.*;








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
		List<Job> query = em.createQuery("Select e from Job e "
			    + "where e.secteur=:secteur",Job.class).getResultList();
				((Query) query).setParameter("secteur",secteur);
				
				
				
				return query;
		
	}
	@Override
	public Job getJobByTitre(String titre) {

		
		return null;
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

	
	
	

}
