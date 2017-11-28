package com.esprit.pidev.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.esprit.pidev.entity.Comment;
import com.esprit.pidev.interfaces.CommentServiceRemote;

@Stateless
@LocalBean
public class CommentService implements CommentServiceRemote {
	@PersistenceContext(unitName="pidev-ejb")
	EntityManager em;

	@Override
	public int AddComment(Comment comment) {
		comment.setDateComment(new Date());
		em.persist(comment);
		return comment.getId();
	}

	@Override
	public List<Comment> getAllComment() {
		TypedQuery<Comment> query = em.createQuery("Select c from Comment c ", Comment.class);
		List<Comment> comments = query.getResultList();

		return comments;
	}

	@Override
	public void deleteCommentById(Integer commentID) {
		Query query= em.createQuery("Delete from Comment c where c.id=:commentID");
		query.setParameter("commentID", commentID);
		query.executeUpdate();
	}

	@Override
	public void updateComment(Comment comment) {
		comment.setDateComment(new Date());
		em.merge(comment);

	}
	
	public List<Comment> getCommentByID() {
		TypedQuery<Comment> query = em.createQuery("Select c from Comment c ", Comment.class);
		List<Comment> comments = query.getResultList();

		return comments;
	}
	
}
