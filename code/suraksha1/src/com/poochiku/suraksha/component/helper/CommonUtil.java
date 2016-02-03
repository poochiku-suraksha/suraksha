package com.poochiku.suraksha.component.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.poochiku.common.KONSTANTS.MAGIC_PARAMS;

public class CommonUtil
{

	public static DBObject getDBObject(JSONObject json)
	{
		return (DBObject) JSON.parse(json.toString());
	}

	public static String generateRandomSurakshaID(String phone)
	{
		Random generator = new Random();
		generator.setSeed(System.currentTimeMillis());
		int num = generator.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999)
		{
			num = generator.nextInt(99999) + 99999;
		}
		return "SURAKSHA" + String.valueOf(num) + phone.substring(5, 10);

	}
	public static String generateRandomFileName()
	{
		Random generator = new Random();
		generator.setSeed(System.currentTimeMillis());
		long time = new Date().getTime();
		int num = generator.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999)
		{
			num = generator.nextInt(99999) + 99999;
		}
		return "file_" + String.valueOf(num) + (time+"").substring(5, 10);

	}

	public static String encode(String s)
	{
		Base64 b64 = new Base64();
		byte[] en = b64.encode(s.getBytes());
		return new String(en);
	}

	public static String decode(String s)
	{
		Base64 b64 = new Base64();
		byte[] de = b64.decode(s.getBytes());
		return new String(de);
	}

	public static String getSurakshaDate(Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		return format.format(date);

	}
	
	public static Response getUnknowResponse()
	{
		return Response.serverError().status(520).entity(Strings.get(MAGIC_PARAMS.ERROR_UNKNOWN)).build();
	}
	public static Response getErrorResponse(String message)
	{
		return Response.serverError().status(520).entity(message).build();
	}
}
