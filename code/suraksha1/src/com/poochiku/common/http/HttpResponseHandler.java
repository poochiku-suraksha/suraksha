package com.poochiku.common.http;

public interface HttpResponseHandler
{

	void onSuccess(Object data);

	void onError(Object error);

	void onResponse(Object response);
}
