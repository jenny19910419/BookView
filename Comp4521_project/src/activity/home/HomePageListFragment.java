package activity.home;

import mockData.MockData;
import hkust.comp4521.project.R;
import activity.bookview.BookViewAdaptor;
import activity.bookview.BookViewInfo;
import activity.bookview.BookView_One;
import activity.fresh.FreshPage;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;


public class HomePageListFragment extends ListFragment
{
	private static final String TAG = "HomePageList";
	
	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	   //wangbo replace the test instance
	    BookViewAdaptor adapter = new BookViewAdaptor(getActivity(),
	    		MockData.BookView.sampleArr1, MockData.Book.sampleArr);

	    setListAdapter(adapter);
	  }
	
	
	 @Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		model.BookView item = (model.BookView) getListAdapter().getItem(position);
	    //Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
	    Intent in = new Intent(getActivity().getApplicationContext(),BookView_One.class);
	    HomePageListFragment.this.startActivity(in);
	 }

}
