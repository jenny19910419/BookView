package activity.popular;

import hkust.comp4521.project.R;
import MockBookViewList.MockBookViewList;
import activity.bookview.BookViewAdaptor;
import activity.bookview.BookViewInfo;
import activity.bookview.BookView_One;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
 
public class PopPage  extends ListFragment {
	 
	private static final String TAG = "PopPage";

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// wangbo replace the test instance
		
		MockBookViewList mkbookviewlist = new MockBookViewList();
		BookViewAdaptor adapter = new BookViewAdaptor(getActivity(),
				mkbookviewlist.bookViewArray2);

		setListAdapter(adapter);
	}
	
	public void onListItemClick(ListView l, View v, int position, long id) {
		BookViewInfo item = (BookViewInfo) getListAdapter().getItem(position);
     }


}