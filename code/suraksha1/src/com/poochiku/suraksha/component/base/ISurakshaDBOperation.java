package com.poochiku.suraksha.component.base;

import javax.ws.rs.core.Response;

import com.poochiku.suraksha.model.ISurakshaEntity;
import com.poochiku.suraksha.model.SurakshaEntity;

public interface ISurakshaDBOperation
{
	
	public Response create(ISurakshaEntity entity);

	public Response read(ISurakshaEntity entity);
	
	public Response readById(ISurakshaEntity entity);

	public Response delete(ISurakshaEntity entity);

	public Response update(ISurakshaEntity entity);

	

}
