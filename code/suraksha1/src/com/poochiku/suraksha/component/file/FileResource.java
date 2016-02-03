package com.poochiku.suraksha.component.file;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.poochiku.suraksha.component.helper.CommonUtil;

@Path("/file")
public class FileResource
{

	private static final String FILE_UPLOAD_PATH = "/drive/temp/images/";
	private static final String CANDIDATE_NAME = "candidateName";
	private static final String SUCCESS_RESPONSE = "Successful";
	private static final String FAILED_RESPONSE = "Failed";

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(
	{ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
	@Path("/upload")
	public Response upload(@Context HttpServletRequest request)
	{

		if (ServletFileUpload.isMultipartContent(request))
		{
			final FileItemFactory factory = new DiskFileItemFactory();
			final ServletFileUpload fileUpload = new ServletFileUpload(factory);

			List items;
			try
			{
				items = fileUpload.parseRequest(request);
				FileController fileController = new FileController();
				return fileController.storeFiles(items);
			}
			catch (Exception e)
			{
				return CommonUtil.getErrorResponse(e.getMessage());
			}
		}
		else
		{
			return CommonUtil.getUnknowResponse();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces("text/plain")
	@Path("/{fileId}")
	public Response getFile(@FormParam("fileIds") String fileIds)
	{
		FileController fileController = new FileController();

		return null;

	}

}
