package activity.MainActivity;

import java.util.Observable;
import java.util.Observer;

import hkust.comp4521.project.R;
import hkust.comp4521.project.WholePage;
import hkust.comp4521.project.R.id;
import hkust.comp4521.project.R.layout;
import hkust.comp4521.project.R.menu;
import model.User;
import myUtil.*;
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

public class MainActivity extends MainActivityController implements Observer
{

	private EditText emailInput = null;
	private Button btnLogin = null;
	private EditText passwordInput = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		emailInput = (EditText) this.findViewById(R.id.myUsername);
		passwordInput = (EditText) this.findViewById(R.id.myPassword);
		
		
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
		this.login(this.emailInput.getText().toString(), this.passwordInput.getText().toString());
		
	}

	@Override
	public void update(Observable observable, Object data) {
		switch((Integer) data) {
		case MainActivityController.STATE_LOGIN_SUCCESS:
			Toast.makeText(this, "Welcome, " + User.get_active_user().email, Toast.LENGTH_SHORT).show();
			break;
		case MainActivityController.STATE_LOGIN_FAIL:
			Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
			break;
		}
		
	}

}
