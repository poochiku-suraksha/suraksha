package com.poochiku.suraksha.component.user;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.poochiku.common.KONSTANTS.MAGIC_PARAMS;
import com.poochiku.suraksha.component.helper.PoochikuLogger;
import com.poochiku.suraksha.model.SurakshaUser;

@Path("/user")
public class UserResource
{

	@Context
	UriInfo uriInfo;

	@Context
	Request request;

	
	@Path("/open")
	@POST
	@Produces(
	{ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName, @FormParam("gender") String gender, @FormParam("email") String email,
			@FormParam("phoneNumber") String phoneNumber, @FormParam("dob") long dob, @FormParam("password") String password)
	{
		SurakshaUser user = new SurakshaUser().setFirstName(firstName).setEmail(email).setLastName(lastName).setDob(dob).setPhoneNumber(phoneNumber).setGender(gender).setPassword(password);
		UserController userController = new UserController();
		return userController.create(user);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("{surakshaId}")
	public Response getUserById(@PathParam("surakshaId") String surakshaId)
	{
		PoochikuLogger.log("Trying to retrieve information for :" + surakshaId, this.getClass());
		UserController userController = new UserController();
		SurakshaUser user = new SurakshaUser().setSurakshaId(surakshaId);
		return userController.readById(user);

	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("/open/login")
	public Response loginByphone(@FormParam(MAGIC_PARAMS.KEY_PHONE_NUMBER) String phone, @FormParam(MAGIC_PARAMS.KEY_SURAKSHA_PASSWORD) String password)
	{
		
		System.out.println("Inside Login");
		
		
		PoochikuLogger.log("Trying to login for :" + phone, this.getClass());
		UserController userController = new UserController();
		SurakshaUser user = new SurakshaUser().setPhoneNumber(phone).setPassword(password);
		return userController.login(user);
		
		

	}
	
	
	
	

}
