package com.esprit.pidev.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.registry.infomodel.User;

import com.esprit.pidev.entity.Category;
import com.esprit.pidev.entity.Message;
import com.esprit.pidev.entity.Users;

import com.esprit.pidev.entity.Reponse;
import com.esprit.pidev.entity.SousCategory;
import com.esprit.pidev.entity.Topic;
import com.esprit.pidev.interfaces.ServiceForumRemote;





@Stateless
@LocalBean
public class ServiceForum implements ServiceForumRemote{
	@PersistenceContext(unitName="pidev-ejb")
	 EntityManager em;
	@Override
	public int addCategory(Category c) {
		em.persist(c);
		return c.getIdCategory();
	}

	@Override
	public void DeleteCategory(int idCategory) {
		Category c=em.find(Category.class, idCategory);
		em.remove(c);
		
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> categories = null;

		TypedQuery<Category> query = em.createQuery("Select c from Category c", Category.class);
		categories = query.getResultList();
		return categories;
	}

	@Override
	public List<Category> getCategoriesByMC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addSousCategory(SousCategory sc) {
		em.persist(sc);
		return sc.getIdSousCategory();
	}

	@Override
	public void DeleteSousCategory(int idSC) {
		SousCategory sc=em.find(SousCategory.class, idSC);
		em.remove(sc);
		
	}

	@Override
	public List<SousCategory> getAllSousCategory( ) {
		List<SousCategory> sousCategories = new ArrayList<SousCategory>();
		TypedQuery<SousCategory> query = em.createQuery("Select s from SousCategory s", SousCategory.class);
		sousCategories = query.getResultList();
	        return sousCategories;
	}
	
	public SousCategory getSousCategoryById(int id) {
		System.out.println("111111");

		SousCategory sc=em.find(SousCategory.class, id);
		System.out.println("111111"+sc);
	        return sc ;

	}

	@Override
	public List<SousCategory> getSousCategoriesByMC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addTopic(Topic t,int idsc,int idUser) {
		SousCategory sc=em.find(SousCategory.class,idsc);
		t.setSousCategory(sc);
		Users u=em.find(Users.class,idUser);
		t.setIdCreateur(u);
		t.getContenu().replaceAll("[b]","<strong>");
		t.getContenu().replaceAll("[/b]","</strong>");
		t.getContenu().replaceAll("[i]","<em>");
		t.getContenu().replaceAll("[/i]","</em>");
		t.getContenu().replaceAll("[u]","<span style='text-decoration: underline;'>");
		t.getContenu().replaceAll("[/u]","</span>");
		t.getContenu().replaceAll("[quote]", "<blockquote>");
		t.getContenu().replaceAll("[/quote]", "</blockquote>");
		em.persist(t);
		return t.getIdTopic();
	}

	@Override
	public void DeleteTopic(int idTopic) {
		Topic t=em.find(Topic.class, idTopic);
		em.remove(t);
		
	}

	@Override
	public List<Topic> getAllTopic() {
		List<Topic> topics = new ArrayList<Topic>();

		TypedQuery<Topic> query = em.createQuery("Select t from Topic t", Topic.class);
		topics = query.getResultList();

	    return topics;
	}

	@Override
	public List<Topic> getAllTopicByMC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addMessage(Message m,int idTopic,int idUser) {
		Topic t=em.find(Topic.class,idTopic);
		m.setTopic(t);
		Users u=em.find(Users.class,idUser);
		m.setIdPosteur(u);  
		em.persist(m);
		return m.getIdMessage();
	}

	@Override
	public void DeleteMessage(int idMessage) {
		Message m=em.find(Message.class, idMessage);
		em.remove(m);
		
	}

	@Override
	public void updateMessage(String contenu,int idm) {
		Message message=em.find(Message.class,idm);
		message.setContenu(contenu);
		em.merge(message);
	}

	@Override
	public List<Message> getAllMessage() {
		List<Message> messages = new ArrayList<Message>();
		TypedQuery<Message> query = em.createQuery("Select m from Message m", Message.class);
		messages = query.getResultList();
	    return messages;
	}

	@Override
	public void addLike(int idUser, int idMessage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int likeMessage(int idMessage) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addResponce(Reponse r,int idMsg,int idUser) {
		Message m=em.find(Message.class,idMsg);
		r.setIdmessage(m);
		Users u=em.find(Users.class,idUser);
		r.setIdUser(u);
		em.persist(r);
		return r.getIdReponse();
	}

	@Override
	public void DeleteResponce(int idResponce) {
		Reponse r=em.find(Reponse.class, idResponce);
		em.remove(r);
		
	}

	@Override
	public void updateResponce(int id,String contenu) {
		Reponse r=em.find(Reponse.class, id);
		r.setContenu(contenu);
		r.setDateEdit(new Date());
		em.merge(r);
	}

	@Override
	public List<Reponse> getAllResponce() {
		List<Reponse> reponses = new ArrayList<Reponse>();
		TypedQuery<Reponse> query = em.createQuery("Select r from Reponse r", Reponse.class);
		reponses = query.getResultList();
	    return reponses;
	}

	










	
	
	
}
