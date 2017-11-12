package com.esprit.pidev.presentation.mbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.esprit.pidev.entity.Job;

@ManagedBean
@ViewScoped
public class ViewBean {

	public ViewBean() {
		// TODO Auto-generated constructor stub
	}
	public Job job;
	
	
	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}


	@PostConstruct
	public void init()
	{
		job = (Job) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("car");

	}
	

}
