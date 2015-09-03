package com.sputnik.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sputnik.entity.UserEntity;
import com.sputnik.service.UserService;

@Path("/sputnikrest")
public class SputnikRest {
	
	@EJB
	private UserService userServiceImpl; 
	
	@POST
	@Path("/saveuser")
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveUserEntity(UserEntity uEntity){
		userServiceImpl.setUserEntity(uEntity);
	}
	
	@GET
	@Path("/showuser")
	@Produces(MediaType.APPLICATION_JSON)
	public UserEntity showUserEntity(){
		return userServiceImpl.getUserEntity();
	}
}
