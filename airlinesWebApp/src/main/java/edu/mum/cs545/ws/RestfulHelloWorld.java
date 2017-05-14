package edu.mum.cs545.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/helloworld")  
public class RestfulHelloWorld {  
    public RestfulHelloWorld() {
		super();
		// TODO Auto-generated constructor stub
	}

	@GET  
    @Produces(MediaType.TEXT_PLAIN)  
    public String sayHelloWorld() {  
        return "Hello World!";  
    }  
  
    @GET  
    @Path("/{param}")  
    @Produces("text/plain;charset=UTF-8")  
    public String sayHello2UserByText(@PathParam("param") String username) {  
        return "Hello " + username;  
    }  
  
    @GET  
    @Path("/get")  
    @Produces(MediaType.APPLICATION_JSON)  
    public List<User> sayHelloToUserByJson(@QueryParam("username") String username) { 
    	List<User> list = new ArrayList<>();
        User user = new User();  
        user.setId(1);  
        user.setName(username);  
        User user1 = new User();  
        user.setId(1);  
        user.setName(username);  
        list.add(user1);
        list.add(user);
        return list;  
    }  
}  