package activity.home;

import hkust.comp4521.project.R;
import MockBookViewList.MockBookViewList;
import activity.bookview.BookViewAdaptor;
import activity.bookview.BookViewInfo;
import android.content.Context;
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
	    MockBookViewList mkbookviewlist= new MockBookViewList();
	    BookViewAdaptor adapter = new BookViewAdaptor(getActivity(), mkbookviewlist.bookViewArray1);

	    setListAdapter(adapter);
	  }
	
	
	 @Override
	public void onListItemClick(ListView l, View v, int position, long id) {
	    BookViewInfo item = (BookViewInfo) getListAdapter().getItem(position);
	    //Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
	 }

}
