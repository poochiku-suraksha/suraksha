/**
 * @author Madhusudhan Mahale
 */
package com.poochiku.suraksha.api.user;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.poochiku.suraksha.api.base.SurakshaApiBase;
import com.poochiku.suraksha.app.SurakshaApplication;
import com.poochiku.suraksha.i18N.ILocale;
import com.poochiku.suraksha.i18N.LocaleFactory;
import com.poochiku.suraksha.model.Contact;
import com.poochiku.suraksha.model.OperationalHeaders;
import com.poochiku.suraksha.model.Phone;
import com.poochiku.suraksha.model.SurakshaUser;
import com.poochiku.suraksha.module.response.SurakshaResponse;
import com.poochiku.suraksha.operations.UserOperation;
import com.poochiku.suraksha.util.SURAKSHA_PARAMS;
import com.poochiku.suraksha.util.SURAKSHA_PARAMS.AUTH_TYPE;
import com.poochiku.suraksha.util.SURAKSHA_PARAMS.KEYS;
import com.poochiku.suraksha.util.SURAKSHA_PARAMS.SURAKSHA_STRINGS;

@Path( "/user" )
public class UserApi extends SurakshaApiBase
{

	public UserApi(@Context
	ServletContext context)
	{
		super(context);

	}

	@POST
	@Consumes( MediaType.APPLICATION_FORM_URLENCODED )
	public Response createuser(@Context
	ContainerRequestContext context,@FormParam( KEYS.EMAIL )
	String email,@FormParam( KEYS.FIRST_NAME )
	String fName,@FormParam( KEYS.LAST_NAME )
	String lName,@FormParam( KEYS.DOB )
	long dob,@FormParam( KEYS.GENDER )
	String gender,@FormParam( KEYS.PASSWORD )
	String password,@FormParam( KEYS.PROFILE_IMG_URL )
	String profileImgUrl,@FormParam( KEYS.PROFILE_SEARCH_ENABLED )
	boolean profileSearchEnabled,@FormParam( KEYS.SURAKSHA_TYPE )
	String surakshaType,@FormParam( KEYS.SURAKSHA_LOCATION_BASE )
	String surakshaBaseLocation,@FormParam( KEYS.PHONE )
	String phone,@FormParam( KEYS.ADDRESS_PRIMARY )
	String address,@FormParam( KEYS.AUTH_TYPE )
	String authType)
	{
		
		OperationalHeaders header = new OperationalHeaders(context);

		if (notNull(authType) && notNull(fName) && (notNull(phone) || notNull(email) && notNull(gender) && notNull(password) && notNull(surakshaType)))
		{

			SurakshaUser user = new SurakshaUser();
			user.setAuthType(authType).setDob(dob).setFirstName(fName).setLastName(lName).setGender(gender).setPassword(password).setPhone((Phone) new Phone().fromJson(phone));
			
			UserOperation userOps = new UserOperation(header);
			return userOps.registerUser(user);

		}
		else
		{
			
			ILocale locale = LocaleFactory.getLocale(header.getLocale());
			return SurakshaResponse.sendBadParameterError(locale.getString(SURAKSHA_STRINGS.UNKNOWN_ERROR));
		}

		
	}

}
