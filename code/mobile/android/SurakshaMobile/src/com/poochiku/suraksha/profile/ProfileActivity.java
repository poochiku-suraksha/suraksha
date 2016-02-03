package com.poochiku.suraksha.profile;

import com.poochiku.suraksha.model.SurakshaUser;
import com.poochiku.suraksha.util.Konstants.MAGIC_PARAMETERS;
import com.poochiku.suraksha.util.StorageManager;
import com.poochiku.suraksha.util.UIManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class ProfileActivity extends Activity
{
	SurakshaUser user ;
	

	public ProfileActivity()
	{
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		UIManager.setActionBarTitle(this, "Suraksha Profile");
		
		SurakshaUser user = (SurakshaUser) StorageManager.retrievePojo(this,MAGIC_PARAMETERS.STORAGE_USER, SurakshaUser.class);
		
		if(user==null)
		{
			//Toast.makeText(this, "No User found", 1).show();
			Intent i = new Intent(this, LoginActivity.class);
			startActivity(i);
			finish();
		}

	}
	
	@Override
	protected void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	@Override
	protected void onPause()
	{
		// TODO Auto-generated method stub
		super.onPause();
	}

	

}
