package com.poochiku.suraksha.component.file;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItem;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import com.poochiku.common.KONSTANTS.COLLECTIONS;
import com.poochiku.suraksha.component.helper.CommonUtil;
import com.poochiku.suraksha.db.DBHandler;
import com.poochiku.suraksha.model.SurakshaUser;

public class FileController
{
	
	public Response storeFiles(List<FileItem> items) throws Exception
	{
		System.out.println("Inside Store Files...");
		
		JSONObject obj = new JSONObject();
		obj.put("name", "madhu");
		
	
		
		
		DB db = DBHandler.getDBInstance();
		JSONObject imageResponse = new JSONObject();
		JSONArray imageArray = new JSONArray();
		DBCollection col = db.getCollection(COLLECTIONS.SURAKSHA_REPORT_IMG);
		if (items != null)
		{
			final Iterator iter = items.iterator();
			while (iter.hasNext())
			{
				final FileItem item = (FileItem) iter.next();
				final String itemName = item.getName();
				final String fieldName = item.getFieldName();
				final String fieldValue = item.getString();

				GridFS gfsPhoto = new GridFS(db,COLLECTIONS.SURAKSHA_REPORT_IMG);
				GridFSInputFile gfsFile = gfsPhoto.createFile(item.getInputStream());
				gfsFile.setFilename(CommonUtil.generateRandomFileName());
				gfsFile.save();
				imageArray.put(gfsFile.getId());
			}
			
			imageResponse.put("fileIds", imageArray);
			
			System.out.println(imageResponse.toString());
			
			return  Response.ok(imageResponse.toString(), MediaType.APPLICATION_JSON).build();
			

		}
		else
		{
			return CommonUtil.getErrorResponse("Please attach Files to upload");
		}
		
	}
	
	public Response retrieveFiles(String[] fileIds) throws IOException
	{
		
		for(int i=0 ;i < fileIds.length ;i ++)
		{
			
			
		}
		
		
		return null;
		
	}

}
