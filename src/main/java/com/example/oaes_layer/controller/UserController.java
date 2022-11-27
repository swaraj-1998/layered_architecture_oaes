package com.example.oaes_layer.controller;

import com.example.oaes_layer.bean.Exam;
import com.example.oaes_layer.bean.User;
import com.example.oaes_layer.service.ExamService;
import com.example.oaes_layer.service.UserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

@Path("user")
public class UserController {
    @POST
    @Path("/register")
    @Produces(MediaType.TEXT_PLAIN) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response registerUser(User user) throws URISyntaxException {
        boolean val = new UserService().registerUser(user); //in service
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }
    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN) //return type
    @Consumes(MediaType.APPLICATION_JSON) //parameter
    public Response loginUser(User user) throws URISyntaxException {
        boolean val = new UserService().loginUser(user); //in service
        if (val == true)
            return Response.ok().build();
        else
            return Response.status(203).build();
    }
}
