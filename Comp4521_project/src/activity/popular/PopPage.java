package activity.popular;

import mockData.MockData;
import hkust.comp4521.project.R;
import activity.bookview.BookViewAdaptor;
import activity.bookview.BookViewInfo;
import activity.bookview.BookView_One;
import activity.fresh.FreshPage;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
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
		BookViewAdaptor adapter = new BookViewAdaptor(getActivity(),
				MockData.BookView.sampleArr1, MockData.Book.sampleArr);

		setListAdapter(adapter);
		
	}
	
	public void onListItemClick(ListView l, View v, int position, long id) {
		model.BookView item = (model.BookView) getListAdapter().getItem(position);
		 Intent in = new Intent(getActivity().getApplicationContext(),BookView_One.class);
	     PopPage.this.startActivity(in);
     }


}