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

import com.esprit.pidev.entity.Message;
import com.esprit.pidev.entity.Topic;
import com.esprit.pidev.services.ServiceForum;


@Path("message")
@RequestScoped
public class ServiceWebMessage {
	@EJB
	ServiceForum SF;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage() {
		 return Response.status(Status.OK).entity(SF.getAllMessage()).build();     
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addMessage(Message m,@QueryParam ("idUser") int idUser,@QueryParam ("idTopic") int idTopic) {
		m.setDatePost(new Date());
		m.setDateEdit(new Date());
		return Response.status(Status.CREATED).entity(SF.addMessage(m, idTopic, idUser)).build();    
		}  

	@PUT
	@Path("{idm}/{contenu}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response UpdateMessage(@PathParam("idm") int idm,@PathParam("contenu")String contenu) {
		SF.updateMessage(contenu,idm);
		return Response.ok("Your Message has been updated").build();    
		}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response DeleteteTopic(@QueryParam ("idMsg") int idmsg) {
       SF.DeleteMessage(idmsg);
		return Response.ok("Your Message has been deleted!").build();

	}
	
}
