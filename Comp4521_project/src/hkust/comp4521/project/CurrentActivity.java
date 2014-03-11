package hkust.comp4521.project;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class CurrentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		TextView textview = new TextView(this);
        textview.setText("This is Current Activity tab");
        setContentView(textview);
		//setContentView(R.layout.activity_current);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.current, menu);
		return true;
	}

}
