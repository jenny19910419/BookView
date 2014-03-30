package activity.fresh;

import model.User;
import hkust.comp4521.project.R;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import myUtil.Callable;

public class FreshPage extends Fragment
{
	private static final String TAG = "FreshPage";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_freshpage, container, false);
		
		this.do_debug();

		return rootView;
	}
	private void do_debug() {
		User.server_list_following(new Callable() {

			@Override
			public void callback(Object d) {
				if(!(d instanceof User[])) {
					Log.e(TAG, "an error occurred");
				}
				User[] userArr = (User[]) d;
				
				Log.d(TAG, Integer.toString(userArr.length));
			}
			
		});
	}

}