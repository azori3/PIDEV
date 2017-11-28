package com.esprit.pidev.presentation.webservice;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/Actionss")
@ManagedBean
@RequestScoped
public class ActionResource {

	@GET
	@Produces("application/json")
	public String getHelo(){
		return "hello";
	}
}
