package ServiceWeb;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.esprit.pidev.entity.Topic;
import com.esprit.pidev.services.ServiceForum;

@Path("souscat")
@RequestScoped
public class ServiceWebSousCat {
	
	@EJB
	ServiceForum SF;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSousCategory() {
		return Response.ok(SF.getAllSousCategory()).build();
	}

}
