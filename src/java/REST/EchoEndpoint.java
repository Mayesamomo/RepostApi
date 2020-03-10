/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author micha
 */
@Path("/echo")
@Produces(MediaType.TEXT_PLAIN)

public class EchoEndpoint {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EchoEndpoint
     */
    public EchoEndpoint() {
    }

    /**
     * Retrieves representation of an instance of REST.EchoEndpoint
     *
     * @return an instance of java.lang.String
     **/
    @GET
    public Response echo(@QueryParam("message") String message) {
        return Response.ok().entity(message == null ? "no message" : message).build();
    }

    @GET
    @Path("jwt")
    public Response echoWithJWTToken(@QueryParam("message") String message) {
        return Response.ok().entity(message == null ? "no message" : message).build();
    }
}
