package activity.compose;

import hkust.comp4521.project.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Compose extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.compose);
		
		EditText bookname = (EditText) findViewById(R.id.composeBookNameTextEdit);
		
		EditText orgText = (EditText) findViewById(R.id.composeBookNameTextEdit);
		
		EditText bookview = (EditText) findViewById(R.id.composeBookNameTextEdit);
		
		Button releaseBut = (Button) findViewById(R.id.releaseButton);
		
		
		releaseBut.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//get information and submit to server
				
			}
			
		});
		


		
		
	}
		
}
