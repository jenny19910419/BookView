package activity.social;

import model.User;
import hkust.comp4521.project.R;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddBookBuddyActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addfollowingview);
		
		EditText email = (EditText) findViewById(R.id.editFollowinggEmailName);
		Button searchButton = (Button) findViewById(R.id.editFollowingButton);
		
		searchButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//check if the email exists int the database;
				
			}
			
		});
		
		
	}
	
}
