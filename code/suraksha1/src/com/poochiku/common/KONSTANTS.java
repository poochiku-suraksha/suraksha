package com.poochiku.common;

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
		public static final String ERROR_INVALID_USERNAME_OR_PASSWORD = "invalid_username_password_error";
		public static final String METHOD_POST = "POST";

		// Keys
		public static final String KEY_PHONE_NUMBER = "phoneNumber";
		public static final String KEY_SURAKSHA_ID = "surakshaId";
		public static final String KEY_SURAKSHA_PASSWORD = "password";
		public static final String KEY_SURAKSHA_TAG = "surakshaTag";
		public static final String KEY_SURAKSHA_CATEGORY = "surakshaCategory";
		public static final String KEY_SURAKSHA_LATITUDE = "latitude";
		public static final String KEY_SURAKSHA_LONGITUDE = "longitude";
		public static final String KEY_SURAKSHA_DESC = "description";
		public static final String KEY_SURAKSHA_USER = "surakshaUser";
		public static final String KEY_SURAKSHA_COMMENT = "comment";
		public static final String KEY_SURAKSHA_IMAGE = "image";

	}

	public static class SURAKSHA_INSTITUTION_TYPE
	{
		public static final String HOME = "suraksha_inst_home";

	}

	public static class COLLECTIONS
	{

		public static final String SURAKSHA_USER = "suraksha_user";
		public static final String SURAKSHA_REPORT_IMG = "suraksha_images";

	}

}
