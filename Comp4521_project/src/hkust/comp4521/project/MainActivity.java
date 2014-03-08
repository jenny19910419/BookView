package hkust.comp4521.project;

import myUtil.*;
import Data.User;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
	private TextView statusBar = null;
	private EditText emailInput = null;
	private EditText passwordInput = null;
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.statusBar = (TextView) this.findViewById(R.id.textView3);
		this.emailInput = (EditText) this.findViewById(R.id.editText1);
		this.passwordInput = (EditText) this.findViewById(R.id.editText2);
		
		// bind events
		final MainActivity that = this;
		Button btnLogin = (Button) this.findViewById(R.id.button1);
		btnLogin.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v) {
				that.login();

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
		this.statusBar.setText("logging in");
		final MainActivity that = this;
		User.server_login(this.emailInput.getText().toString(), this.passwordInput.getText().toString(), new Callable()
		{
			@Override
			public void callback(final Object d) {
				that.handler.post(new Runnable() {
					public void run() {
						if(d == null) {
							that.statusBar.setText("login failed");
							return;
						}
						User user = (User) d;
						that.statusBar.setText("Welcome, "+user.email);				
					}
					
				});
				
			}

		});
	}

}
