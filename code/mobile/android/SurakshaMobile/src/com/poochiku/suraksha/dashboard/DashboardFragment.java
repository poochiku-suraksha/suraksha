package com.poochiku.suraksha.dashboard;

import com.poochiku.suraksha.mobile.R;
import com.poochiku.suraksha.util.Konstants.MAGIC_PARAMETERS;
import com.poochiku.suraksha.util.StorageManager;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class DashboardFragment extends Fragment
{

	public DashboardFragment()
	{
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{

		View rootView = inflater.inflate(R.layout.fragement_dashboard, container, false);

		String user = StorageManager.retrieve(getActivity(), MAGIC_PARAMETERS.STORAGE_USER);
		
		if(user == null)
		{
			//Toast.makeText(getActivity(), "No User found", 1).show();
			
		}

		return rootView;
	}

}
