package com.poochiku.suraksha.component.userreport;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.JSONArray;

import com.google.gson.Gson;
import com.poochiku.common.KONSTANTS.MAGIC_PARAMS;
import com.poochiku.suraksha.model.SurakshaCategory;
import com.poochiku.suraksha.model.SurakshaTag;
import com.poochiku.suraksha.model.SurakshaUser;
import com.poochiku.suraksha.model.SurakshaUserReport;

@Path("/userreport")
public class ReportResource
{


	@POST
	@Path("/upload1")
	@Consumes(
	{  MediaType.APPLICATION_FORM_URLENCODED })
	public Response uploadPdfFile1(@FormParam(MAGIC_PARAMS.KEY_SURAKSHA_TAG) String tag, @FormParam(MAGIC_PARAMS.KEY_SURAKSHA_CATEGORY) String category,
			@FormParam(MAGIC_PARAMS.KEY_SURAKSHA_COMMENT) String comment, @FormParam(MAGIC_PARAMS.KEY_SURAKSHA_DESC) String desc, @FormParam(MAGIC_PARAMS.KEY_SURAKSHA_USER) String user,
			@FormParam(MAGIC_PARAMS.KEY_SURAKSHA_LATITUDE) long latitude, @FormParam(MAGIC_PARAMS.KEY_SURAKSHA_LONGITUDE) long longitude , @FormParam("fileIds") JSONArray fileIds) throws Exception
	{

		ReportResourceController controller = new ReportResourceController();
		Gson gson = new Gson();
		SurakshaUserReport report = new SurakshaUserReport();
		SurakshaUser sUser = gson.fromJson(user, SurakshaUser.class);
		SurakshaTag sTag = gson.fromJson(tag, SurakshaTag.class);
		SurakshaCategory sCategory = gson.fromJson(category, SurakshaCategory.class);

		report.setCategory(sCategory).setComment(comment).setDescription(desc).setLatitude(latitude).setLongitude(longitude).setSurakshaUser(sUser).setTag(sTag).setFileIds(fileIds);

		return controller.create(report);

	}
	
	@POST
	@Path("/upload")
	@Consumes(
	{  MediaType.APPLICATION_FORM_URLENCODED })
	public Response uploadPdfFile(
			@FormParam(MAGIC_PARAMS.KEY_SURAKSHA_COMMENT) String comment,
			@FormParam(MAGIC_PARAMS.KEY_SURAKSHA_LATITUDE) long latitude, @FormParam(MAGIC_PARAMS.KEY_SURAKSHA_LONGITUDE) long longitude ) throws Exception
	{
		System.out.println("ha ha ha");

		return Response.ok().build();

	}

}
