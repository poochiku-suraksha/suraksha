package com.poochiku.suraksha.adapters;

import com.poochiku.suraksha.mobile.R;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class IncidentCursorAdapter extends CursorAdapter
{

	public IncidentCursorAdapter(Context context, Cursor c)
	{
		super(context, c);
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent)
	{
		return LayoutInflater.from(context).inflate(R.layout.incident_listview, parent, false);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor)
	{
		TextView tvBody = (TextView) view.findViewById(R.id.tvBody);
		TextView tvPriority = (TextView) view.findViewById(R.id.tvPriority);
		// Extract properties from cursor
		String body = cursor.getString(cursor.getColumnIndexOrThrow("body"));
		int priority = cursor.getInt(cursor.getColumnIndexOrThrow("priority"));
		// Populate fields with extracted properties
		tvBody.setText(body);
		tvPriority.setText(String.valueOf(priority));

	}

}
