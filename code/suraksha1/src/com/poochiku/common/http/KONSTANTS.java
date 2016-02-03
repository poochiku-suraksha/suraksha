package com.poochiku.common.http;

public class KONSTANTS
{

	public static class HTTP
	{
		public static final String METHOD_GET = "GET";
		public static final String METHOD_POST = "POST";

	}

	public static class MAGIC_PARAMS
	{
		// Errors
		public static final String ERROR_HTTP_USER_EXISTS = "already_registered_error";
		public static final String ERROR_HTTP_USER_NOT_FOUND = "user_notfound_error";
		public static final String ERROR_UNKNOWN = "unknown_error";
		public static final String METHOD_POST = "POST";

		// Keys
		public static final String KEY_PHONE_NUMBER = "phoneNumber";
		public static final String KEY_SURAKSHA_ID = "surakshaId";

		// Collections

		public static final String COLLECTION_SURAKSHA_USER = "suraksha_user";

	}

	public static class SURAKSHA_INSTITUTION_TYPE
	{
		public static final String HOME = "suraksha_inst_home";

	}

}
