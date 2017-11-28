package ServiceWeb;

import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.esprit.pidev.entity.Topic;
import com.esprit.pidev.services.ServiceForum;

@Path("topic")
@RequestScoped
public class ServiceWebTopic {
	
	@EJB
	ServiceForum SF;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTopic() {
		 return Response.status(Status.OK).entity(SF.getAllTopic()).build();     
	}
	
	/*
	 @GET  
	 @Produces(MediaType.APPLICATION_JSON)  
	 public Response getTopicByMC(@QueryParam ("rech") String rech){   
		 if(refLogement != null){    
			 List<RendezVous> liste = rdvMetier.getListeRendezVousByLogementReference(refLogement);    
			 if(liste != null && liste.size() != 0){     
				 return Response.status(Status.OK).entity(liste).build();    
				 }    
			 return Response.status(Status.NOT_FOUND).entity("Votre liste de rendez-vous pour la reference de logement: "+ refLogement +" est vide !").build();   
	  
	   } 
		 return Response.status(Status.OK).entity().build();     
	   } */ 
	
	
	@POST
	@Path("{idUser}/{idSousCat}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces
	public Response addRendezVous(Topic t,@PathParam ("idUser") int idUser,@PathParam ("idSousCat") int idSC) {
		System.out.println("topic:"+idSC+" "+idUser);
		t.setDateCreation(new Date());
		SF.addTopic(t, idSC, idUser);
		return Response.status(Status.CREATED).entity("add topic").build();    
		}  

	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response DeleteteTopic(@QueryParam ("idTopic") int idTopic) {
       SF.DeleteTopic(idTopic);
		return Response.ok("Your Topic has been deleted!").build();

	}
	

}
