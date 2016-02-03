package com.poochiku.suraksha.profile;

import java.util.Date;

import com.poochiku.suraksha.api.ISurakshaResponseHandler;
import com.poochiku.suraksha.api.PoochikuApi;
import com.poochiku.suraksha.contract.ISurakshaEntity;
import com.poochiku.suraksha.mobile.R;
import com.poochiku.suraksha.mobile.R.id;
import com.poochiku.suraksha.model.SurakshaUser;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
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
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class RegistrationActivity extends Activity implements OnDateChangedListener, OnClickListener
{
	private String[] listOfObjects;

	private TypedArray images;
	private ImageView itemImage;
	DatePicker datePicker;
	Button btnRegSubmit;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);

		setUI();

	}

	private void setUI()
	{
		setCountrySpinner();
		datePicker = (DatePicker) findViewById(R.id.date_picker);
		datePicker.init(1960, 1, 1, this);
		btnRegSubmit = (Button) findViewById(R.id.btnRegSubmit);
		btnRegSubmit.setOnClickListener(this);

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

				// Toast.makeText(getApplicationContext(), cc, 1).show();

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{
			}
		});

	}

	@Override
	public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth)
	{
		Toast.makeText(getApplicationContext(), dayOfMonth + ":-" + monthOfYear + "-" + year, 1).show();

	}

	@Override
	public void onClick(View v)
	{
		switch (v.getId())
		{
		case R.id.btnRegSubmit:

			SurakshaUser user = new SurakshaUser().setDob(new Date().getTime()).setEmail("mahale.labs@gmail.com").setFirstName("Madhu").setLastName("mahale").
			setPhoneNumber("+917738045133").setPassword("password@123").setGender("male");

			PoochikuApi api = new PoochikuApi();
			api.createuser(user, getApplicationContext(), new ISurakshaResponseHandler()
			{
				
				@Override
				public void onSuccess(ISurakshaEntity data)
				{
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onError(ISurakshaEntity error)
				{
					// TODO Auto-generated method stub
					
				}
			});
			
			break;

		}

	}
}
