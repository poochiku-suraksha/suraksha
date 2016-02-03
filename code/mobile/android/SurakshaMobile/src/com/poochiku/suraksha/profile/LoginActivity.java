package com.poochiku.suraksha.profile;


import com.poochiku.suraksha.mobile.R;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class LoginActivity extends Activity implements OnClickListener
{

	private String[] listOfObjects;

	private TypedArray images;
	private ImageView itemImage;

	private Button btnSubmit;
	private TextView tvRegister, tvForgotPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		setUI();

	}

	private void setUI()
	{
		setCountrySpinner();

		btnSubmit = (Button) findViewById(R.id.btnLoginSubmit);
		tvRegister = (TextView) findViewById(R.id.btnRegistration);
		tvForgotPassword = (TextView) findViewById(R.id.btnforgetPass);

		btnSubmit.setOnClickListener(this);
		tvRegister.setOnClickListener(this);
		tvForgotPassword.setOnClickListener(this);

	}

	private void setCountrySpinner()
	{
		listOfObjects = getResources().getStringArray(R.array.object_array);
		images = getResources().obtainTypedArray(R.array.object_image);
		TextView spinnerHeader = (TextView) findViewById(R.id.textView);
		itemImage = (ImageView) findViewById(R.id.imageView);
		final Spinner spinner = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, listOfObjects);
		spinnerAdapter.setDropDownViewResource(R.layout.spinner_item);
		spinner.setAdapter(spinnerAdapter);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{

				itemImage.setImageResource(images.getResourceId(spinner.getSelectedItemPosition(), -1));

				String cc = listOfObjects[position];

				//Toast.makeText(getApplicationContext(), cc, 1).show();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
			}
		});

	}

	@Override
	public void onClick(View v)
	{

		switch (v.getId())
		{
		case R.id.btnLoginSubmit:

			break;
		case R.id.btnRegistration:
			
			Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
			startActivity(intent);

			break;
		case R.id.btnforgetPass:

			break;

		default:
			break;
		}
	}

}
