package com.poochiku.suraksha.api;

import com.poochiku.suraksha.contract.ISurakshaEntity;

public interface ISurakshaResponseHandler
{
	void onSuccess(ISurakshaEntity data);
	void onError(ISurakshaEntity error);
}
