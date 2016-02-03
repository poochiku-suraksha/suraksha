package com.poochiku.suraksha.govt;

import com.poochiku.suraksha.mobile.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GovtActivity extends Activity
{

	WebView govtWebView;
	String url ="http://india.gov.in/";//"http://www.ndtv.com/topic/indian-government/news";

	public GovtActivity()
	{
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_govt);
		govtWebView = (WebView)findViewById(R.id.govtWebview);
		govtWebView.setWebViewClient(new MyBrowser());
		govtWebView.getSettings().setLoadsImagesAutomatically(true);
		govtWebView.getSettings().setJavaScriptEnabled(true);
		govtWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		govtWebView.loadUrl(url);

	}


	private class MyBrowser extends WebViewClient
	{
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url)
		{
			view.loadUrl(url);
			return true;
		}
	}

}
