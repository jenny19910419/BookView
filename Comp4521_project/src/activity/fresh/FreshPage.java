package activity.fresh;

import model.User;
import hkust.comp4521.project.R;
import MockBookViewList.MockBookViewList;
import activity.bookview.BookViewAdaptor;
import activity.bookview.BookViewInfo;
import activity.bookview.BookView_One;
import activity.bookview.TestAdapter;
import android.content.Intent;
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
	    
	    //replaced by mockviewlist
	    MockBookViewList mkbookviewlist = new MockBookViewList();
		BookViewAdaptor adapter = new BookViewAdaptor(getActivity(),
				mkbookviewlist.bookViewArray);
	
	    setListAdapter(adapter);
	  }
	
	
	 @Override
	public void onListItemClick(ListView l, View v, int position, long id) {
	    BookViewInfo item = (BookViewInfo) getListAdapter().getItem(position);
	    //Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
        
	    Intent in = new Intent(getActivity().getApplicationContext(),BookView_One.class);
	    FreshPage.this.startActivity(in);
         
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