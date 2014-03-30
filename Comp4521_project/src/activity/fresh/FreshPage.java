package activity.fresh;

import model.User;
import hkust.comp4521.project.R;

import activity.bookview.BookViewAdaptor;
import activity.bookview.BookViewInfo;
import activity.bookview.TestAdapter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import myUtil.Callable;

public class FreshPage extends ListFragment
{
	private static final String TAG = "FreshPage";
	
	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    
	    //BookViewInfo bookViewOne = new BookViewInfo("first org", "first review", R.drawable.testpor1);
	    //BookViewInfo bookViewTwo = new BookViewInfo("second org", "second review", R.drawable.testpor2);
	    
	    //here adjust sth to retrieve data from the database
	    String[] originalText = new String[] {"first org", "second org"};
	    String[] reviewText = new String[] {"first review", "second review"};
	    int[] portrait = new int[] {R.drawable.testpor1,R.drawable.testpor2};
	   
	    
	    /*BookViewAdaptor adapter = new BookViewAdaptor(getActivity(),
	    		originalText,reviewText,portrait);*/
	    BookViewAdaptor adapter = new BookViewAdaptor(getActivity(), originalText, reviewText,portrait);

	    setListAdapter(adapter);
	  }
	
	
	 @Override
	public void onListItemClick(ListView l, View v, int position, long id) {
	    String item = (String) getListAdapter().getItem(position);
	    //Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
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