/**
 * @author Madhusudhan Mahale
 */
package com.poochiku.suraksha.util;

public class SURAKSHA_PARAMS
{

	public static class COLLECTIONS
	{
		
		public static final String SURAKSHA_USERS= "suraksha_users";

	}

	public static class KEYS
	{

		public static final  String AUTH_TYPE = "authType";
		public static final  String EMAIL = "email";
		public final static String PHONE = "phone";
		public final static String NUMBER = "number";
		public final static String COUNTRY_CODE = "countryCode";
		public final static String FIRST_NAME = "firstName";
		public final static String LAST_NAME = "lastName";
		public final static String DOB = "dob";
		public final static String GENDER = "gender";
		public final static String PASSWORD = "password";
		public final static String PROFILE_IMG_URL = "profileImgUrl";
		public final static String PROFILE_SEARCH_ENABLED = "profileSearchEnabled";
		public final static String SURAKSHA_ID = "surakshaId";
		public final static String SURAKSHA_TYPE = "surakshaType";
		public final static String SURAKSHA_LOCATION_BASE = "surakshaBaseLocation";
		public final static String SURAKSHA_LOCATION_CURRENT = "surakshaCurrentLocation";
		public final static String SURAKSHA_SECURED_FACTOR = "surakshaSecuredFactor";
		public final static String PHONE_PRIMARY = "primaryPhone";
		public final static String ADDRESS_PRIMARY = "primaryAddress";
		
		//Signal
		final static String PANIC = "panic";
		final static String LOCATION_ROUTINE = "loc_routine";
		final static String LOCATION_UPDATE = "loc_update";


	}

	public static class HTTP
	{
		final static String METHOD_POST = "POST";
		final static String METHOD_PUT = "PUT";
		final static String METHOD_GET = "GET";

	}

	public static class AUTH_TYPE
	{
		public final static String PHONE = "phone";
		public final static String EMAIL = "email";
		public final static String FACEBOOK = "facebook";
		public final static String LINKEDIN = "linkedIn";

	}

	public static class SURAKSHA_ENTITY_SUB_TYPE
	{

		final static String HOME = "home";
		final static String SCHOOL = "school";
		final static String POLICE_STATION = "police_station";
		final static String COLLEGE = "college";
		final static String GOVT_OFFICE = "govt_office";
		final static String COMPANY_ANY = "company_any";

	}

	public static class SURAKSHA_ENTITY_TYPE
	{

		final static String USER = "user";
		final static String GROUP = "group";
		final static String INSTITUTION = "institution";

	}
	
	public static class SURAKSHA_SIGNAL
	{

		final static int PANIC = 100;
		final static int LOCATION_ROUTINE = 201;
		final static int LOCATION_UPDATE = 202;

	}
	
	
	public static class SURAKSHA_STRINGS
	{

		public final static String MANDATORY_PARAMS_MISSING = "mandatory_params_missing";
		public final static String LOCATION_ROUTINE = "invalid_username_password_error";
		public final static String UNKNOWN_ERROR = "unknown_error";
		public final static String USER_NOT_FOUND = "user_notfound_error";
		public final static String USER_ALREADY_RESGISTERED = "user_already_registered_error";
		

	}
	

	public static class SURAKSHA_LOCALE
	{

		public final static String ENGLISH = "english";
		public final static String HINDI = "hindi";
		
		

	}
	
	
	

}
