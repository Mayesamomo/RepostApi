/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import DAO.PostDAO;
import DAO.PostInterface;
import DTO.Post;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * REST Web Service
 *
 * @author micha
 */
@Path("Post")
public class PostResource {

    @Context
    private UriInfo context;
    private PostInterface postDB = PostDAO.getInstance();
    private Post p = new Post();

    /**
     * Creates a new instance of PostResource
     */
    public PostResource() {
    }

    /**
     * Retrieves representation of an instance of REST.PostResource
     *
     * @return an instance of java.lang.String
     */
    //Returns all active posts .
    @GET
    @Path("/ActivePosts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getActivePosts() {
        List<Post> posts = postDB.getAllActivePosts();
        if (posts == null || posts.isEmpty()) {
            return (List<Post>) Response.status(204).entity("no content found in the database!").build();
        }
        //return list of users
        return postDB.getAllActivePosts();
    }

    @GET
    @Path("/AllPost")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getAllPosts() {
        List<Post> posts = postDB.getAllPosts();
        if (posts == null || posts.isEmpty()) {
            return (List<Post>) Response.status(204).entity("no content found in the database!").build();
        }
        //return list of users
        return postDB.getAllPosts();
    }

    @GET
    @Path("{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("Id") int id) {
        List<Post> post = postDB.getPostById(id);
        if (post == null || post.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response.ok().entity(post).build();
        }

    }

    /**
     * PUT method for updating or creating an instance of PostResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    //create Posts
    @POST
    @Path("/CreatePost")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.TEXT_PLAIN)
    public Response CreatePost(Post post) {
        if (post.getPost_title() == null && post.getPost_desc() == null && post.getUser_id() < 1 && post.getCommunity_id() < 1) {
            return Response.status(204).entity("Please provide all your details !!").build();
        }
        postDB.addPost(p);
        return Response.status(200).entity("Post Added!").build();

    }
}
