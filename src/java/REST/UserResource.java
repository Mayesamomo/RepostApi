/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import DAO.UserDAO;
import DAO.UserInterface;
import DTO.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * REST Web Service
 *
 * @author micha
 */
@RolesAllowed({"USER", "MODERATOR", "ADMIN"})
@Path("User")
public class UserResource {

    private final UserInterface db = UserDAO.getInstance();
    //private final String USERNAME_FORMAT = "[A-Z]+[a-zA-Z]";
    private final String EMAIL_FORMAT = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final String PASSWORD_FORMAT = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";
    @Context
    private HttpServletRequest request;
    private UriInfo context;
    private User u = new User();

    /**
     * Creates a new instance of UserResource
     */
    public UserResource() {
    }

    //conver user Object to JSON Object
    private JSONObject convertUserToJson(User u) {
        JSONObject jObj = new JSONObject();
        jObj.put("user_id", u.getId());
        jObj.put("fullName", u.getFullName());
        jObj.put("user_name", u.getUsername());
        jObj.put("email", u.getEmail());
        jObj.put("password", u.getPassword());
        jObj.put("user_type", u.getUserType());
        jObj.put("user_status", u.getStatus());
        jObj.put("date", u.getDate());
        return jObj;
    }

    private User convertJsonStringToLogin(String log) throws org.json.simple.parser.ParseException {
        User users = null;
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(log);
        //creating a new user object and passing data into them.
        users = new User();
        users.setUsername((String) obj.get("user_name"));
        users.setPassword((String) obj.get("password")); //password must not be return
        return u;

    }
    //convert JSON Object to User object

    private User convertJsonStringToUser(String jsonString) {
        User users = null;
        users = new User();
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
            obj = (JSONObject) parser.parse(jsonString);
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(UserResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        //creating a new user object and passing data into them.
        //int userId = ((int) obj.get("user_id"));
        //users.setId(userId);
        users.setFullName((String) obj.get("fullName"));
        users.setUsername((String) obj.get("user_name"));
        users.setPassword((String) obj.get("password")); //password must not be return
        users.setEmail((String) obj.get("email"));
        // String usertype = (String) (obj.get("user_type"));
        //users.setUserType(UserType.valueOf(usertype));
        //int status = ((Long) obj.get("user_status")).intValue();
        // u.setStatus(status);
        return u;
    }

    /**
     * Retrieves representation of an instance of REST.UserResource
     *
     * @return an instance of java.lang.String
     */
    //get all users, only accessible by Admin
    @RolesAllowed("ADMIN")
    @GET
    @Path("/AllUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        List<User> users = db.getAllUsers();
        if (users == null || users.isEmpty()) {
            return (List<User>) Response.status(204).entity("no user found in the database!").build();
        }
        //return list of users
        return db.getAllUsers();
    }

    /**
     * PUT method for updating or creating an instance of UserResource
     *
     * @param users
     * @return
     */
    @PUT
    //@Path("/updateUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(User users) {
        System.out.println(users);
        if (!db.checkIfExist(users.getUsername(), users.getEmail())) {
            //status code 204
            return Response.status(204).entity("user not found!").build();

        } else {
            db.updateCustomer(u);
            return Response.status(200).entity("details updated!").build();
        }
    }

    //get a details with username
    @PermitAll
    @GET
    @Path("{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("Id") int id) {
        List<User> users = db.getUsers(id);
        if (users == null || users.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response.ok()
                    .entity(users)
                    .build();
        }

    }

    @PermitAll
    @POST
    @Path("/Login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.TEXT_PLAIN)
    public Response Login(User us) {
        //u = convertJsonStringToLogin(content);
        if (us.getUsername() == null && us.getPassword() == null) {
            request.getSession(false);
            return Response.status(400).entity("Please enter username and password !!").build();

        }
        if (!db.login(us.getUsername(), us.getPassword())) {
            request.getSession(false);
            return Response.status(401).entity("wrong username or password !!").build();
        } else {
            db.login(us.getUsername(), us.getPassword());
            request.getHeader("Autorization");
            request.setAttribute("use_id", u.getId());
            request.getSession(true);
            return Response.status(200).entity("Logged In!").build();
        }
    }

    @POST
    @Path("/Register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.TEXT_PLAIN)
    public Response registerUser(User us) {
        boolean exist = db.checkIfExist(us.getUsername(), us.getEmail());
        if (us.getFullName() == null && us.getUsername() == null && us.getEmail() == null && us.getPassword() == null) {
            return Response.status(400).entity("Please provide all your details !!").build();
        }
        if (exist) {
            return Response.status(400).entity("account already exist!").build();
        } else {
            db.register(us);
            return Response.status(200).entity("account created").build();
        }
    }
}
