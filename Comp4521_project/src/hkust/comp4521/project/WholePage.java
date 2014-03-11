package hkust.comp4521.project;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class WholePage extends TabActivity {
	@SuppressLint("NewApi")

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_whole_page);
		
		//Make sure we're running on Honeycomb or higher to use ActionBar APIs
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			//Show up the Up Button in the action bar
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
		Resources resources = getResources();
		TabHost tabHost = getTabHost();
		
		//CurrentActivity tab
		Intent intentCurrent = new Intent().setClass(this,CurrentActivity.class);
		TabSpec tabSpecCurrent = tabHost.newTabSpec("Current")
				.setIndicator("Current")
				.setContent(intentCurrent);
		
		//HomeActivity tab
		Intent intentHome = new Intent().setClass(this, HomeActivity.class);
		TabSpec tabSpecHome = tabHost
				.newTabSpec("Home")
				.setIndicator("Home")
				.setContent(intentHome);
		
		//Interesting tab
		Intent intentInterest = new Intent().setClass(this, InterestingActivity.class);
		TabSpec tabSpecInterests = tabHost
				.newTabSpec("Interest")
				.setIndicator("Interesting")
				.setContent(intentInterest);
		
		//add all tabs
		tabHost.addTab(tabSpecCurrent);
		tabHost.addTab(tabSpecHome);
		tabHost.addTab(tabSpecInterests);
		
		//set Current tab as default
		tabHost.setCurrentTab(0);
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.whole_page, menu);
		return super.onCreateOptionsMenu(menu);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) {
		case R.id.action_search:
			//openSearch();
			return true;
		case R.id.action_circle:
			return true;
			//openCircle();
		default:
			return super.onOptionsItemSelected(item);
		}
	
	}

}
