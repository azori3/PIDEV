package com.esprit.pidev.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.pidev.entity.Comment;

@Remote
public interface CommentServiceRemote {
    public int AddComment(Comment comment);
	
	public List<Comment> getAllComment();
	
	public void deleteCommentById(Integer commentID);
	
	public void updateComment(Comment comment);
	

}
