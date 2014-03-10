package hkust.comp4521.project;

import myUtil.*;
import Data.User;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{

	private EditText emailInput = null;
	private Button btnLogin = null;
	private EditText passwordInput = null;
	private Toast toast = null;
	private Handler handler = new Handler();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		emailInput = (EditText) this.findViewById(R.id.myUsername);
		passwordInput = (EditText) this.findViewById(R.id.myPassword);
		
		 toast = Toast.makeText(this, "Welcome", Toast.LENGTH_LONG);
		 toast.show();
		
		// bind events
		btnLogin = (Button) this.findViewById(R.id.loginBut);
		btnLogin.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				login();

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    
	public void login() {
	
		User.server_login(this.emailInput.getText().toString(), this.passwordInput.getText().toString(), new Callable()
		{
			@Override
			public void callback(final Object d) {
				handler.post(new Runnable() {
					public void run() {
						if(d == null) {
							if(toast!=null ) {
								toast.setText("login failed");
								toast.show();
								}
							return;
						}
						User user = (User) d;
						if(toast!=null) {
							toast.setText("Welcome, "+user.email);
							toast.show();	
							
							//go to WholePage
							Intent intent = new Intent(MainActivity.this, WholePage.class);
							startActivity(intent);
						}
					}
					
				});
				
				
			}

		});
	}

}
