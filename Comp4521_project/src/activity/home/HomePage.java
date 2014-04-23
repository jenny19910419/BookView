package activity.home;

import hkust.comp4521.project.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class HomePage extends Fragment {
	 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	View rootView = inflater.inflate(R.layout.fragment_homepage, container, false);
    	//set user name and user portrait
    	TextView user_name= (TextView)rootView.findViewById(R.id.home_page_username);
    	ImageView user_portrait = (ImageView) rootView.findViewById(R.id.home_page_icon);
    	//bookview and testpor1 is the mock user information
    	user_name.setText("bookview");
    	user_portrait.setImageResource(R.drawable.testpor1);
        return rootView;
    }
 }