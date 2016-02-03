package com.poochiku.suraksha.component.userreport;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import com.poochiku.common.KONSTANTS.COLLECTIONS;
import com.poochiku.suraksha.component.base.ISurakshaDBOperation;
import com.poochiku.suraksha.component.helper.CommonUtil;
import com.poochiku.suraksha.db.DBHandler;
import com.poochiku.suraksha.model.ISurakshaEntity;

public class ReportResourceController implements ISurakshaDBOperation
{

	@Override
	public Response create(ISurakshaEntity entity)
	{

		return null;
	}

	public Response create(ISurakshaEntity entity, InputStream is, FormDataContentDisposition fileMetaData)
	{
		DB db;
		try
		{
			db = DBHandler.getDBInstance();
			DBCollection col = db.getCollection(COLLECTIONS.SURAKSHA_REPORT_IMG);
			File imageFile = new File("/drive/temp/images/test.jpg");
			GridFS gfsPhoto = new GridFS(db,COLLECTIONS.SURAKSHA_REPORT_IMG);
			GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
			gfsFile.setFilename(CommonUtil.generateRandomFileName());
			gfsFile.save();
			return Response.ok().build();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Response read(ISurakshaEntity entity)
	{
		return null;
	}

	@Override
	public Response readById(ISurakshaEntity entity)
	{
		return null;
	}

	@Override
	public Response delete(ISurakshaEntity entity)
	{
		return null;
	}

	@Override
	public Response update(ISurakshaEntity entity)
	{
		return null;
	}

}
