package com.esprit.pidev.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.entity.Category;
import com.esprit.pidev.entity.Message;
import com.esprit.pidev.entity.Reponse;
import com.esprit.pidev.entity.SousCategory;
import com.esprit.pidev.entity.Topic;

@Remote
public interface ServiceForumRemote {
	//category
	public int addCategory(Category c);
	public void DeleteCategory(int idCategory);
	public List<Category> getAllCategory();
	public List<Category> getCategoriesByMC();
	//sous category
	public int addSousCategory(SousCategory sc);
	public void DeleteSousCategory(int idSC);
	public List<SousCategory> getAllSousCategory();
	public List<SousCategory> getSousCategoriesByMC();
	//Topic
	public int addTopic(Topic t,int idsc,int idUser);
	public void DeleteTopic(int idTopic);
	public List<Topic> getAllTopic();
	public List<Topic> getAllTopicByMC();
	//message
	public int addMessage(Message m,int idtopic,int idUser);
	public void DeleteMessage(int idMessage);
	public void updateMessage(String contenu,int idm);
	public List<Message> getAllMessage();
	public void addLike(int idUser,int idMessage);
	public int likeMessage(int idMessage);
	//reponse
	public int addResponce(Reponse r,int idMsg,int idUser);
	public void DeleteResponce(int idResponce);
	public void updateResponce(int id,String contenu);
	public List<Reponse> getAllResponce();
	
	
	

}
