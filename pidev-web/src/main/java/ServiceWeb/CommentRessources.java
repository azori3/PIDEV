package ServiceWeb;


import java.util.Date;
import java.util.List;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.esprit.pidev.entity.Comment;
import com.esprit.pidev.interfaces.CommentServiceRemote;

@Path("comments")
@RequestScoped
public class CommentRessources {

	private String content;
	private List<Comment> comms;

	@EJB
	CommentServiceRemote service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getc")
	public Response getComments() {
		return Response.ok(service.getAllComment()).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("addc")
	public Response addC(Comment cm) {
		service.AddComment(cm);
		return Response.status(Status.CREATED).entity("Comment added").build();
	}
	
	@DELETE
	@Path("delete/{id}")
	public Response deleteVehicle(@PathParam("id") Integer id) {
		service.deleteCommentById(id);
		return Response.status(Status.OK).entity("Comment Deleted succesfully!!!").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("editc")
	public Response updateComment(Comment c) {
		service.updateComment(c);
		return Response.status(Status.OK).entity("Comment updated succesfully !").build();
	}
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Comment> getComms() {
		return comms;
	}

	public void setComms(List<Comment> comms) {
		this.comms = comms;
	}

}
