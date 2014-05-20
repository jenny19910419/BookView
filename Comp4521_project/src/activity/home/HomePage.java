package activity.home;

import model.User;
import hkust.comp4521.project.R;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePage extends Fragment {
	
	 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	View rootView = inflater.inflate(R.layout.fragment_homepage, container, false);
    	
    	ImageView portrait = (ImageView) rootView.findViewById(R.id.homepage_icon);
    	//BitmapDrawable d = new BitmapDrawable(User.get_active_user().imageUrl);
    	//portrait.setImageDrawable(d);
    	BitmapDrawable d = new BitmapDrawable(getResources(),User.get_active_user().get_image());
    	portrait.setImageDrawable(d);
    	
    	
    	TextView email = (TextView) rootView.findViewById(R.id.homepage_email);
    	email.setText(User.get_active_user().email );
    	TextView username = (TextView) rootView.findViewById(R.id.homepage_username);
    	username.setText(User.get_active_user().name);

        return rootView;
    }
 }