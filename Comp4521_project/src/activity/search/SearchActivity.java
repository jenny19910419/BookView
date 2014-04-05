package activity.search;

import java.util.ArrayList;

import hkust.comp4521.project.R;
import activity.bookview.BookViewAdaptor;
import activity.bookview.BookViewInfo;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

/*public class SearchActivity extends ListActivity {


 @Override
 public void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.fragment_search);
 // Get the SearchView and set the searchable configuration
 SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
 //SearchView searchView = (SearchView) findItemById(R.id.);
 //searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
 //searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

 // Get the intent, verify the action and get the query
 Intent intent = getIntent();
 if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
 String query = intent.getStringExtra(SearchManager.QUERY);
 doMySearch(query);
 }
 }

 private void doMySearch(String query) {
 // TODO Auto-generated method stub

 }

 }*/

/*
 * class that performs searches based on a query string and presents the search results.
 * Retrieve the query
 * Search your data
 * Presenting your result
 */
public class SearchActivity extends ListActivity {

	private BookViewInfo[] searchResult;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_search);

		// Get the intent, verify the action and get the query
		Intent intent = getIntent();
		handleIntent(getIntent());

		// display the result
		BookViewAdaptor adapter = new BookViewAdaptor(this, searchResult);
		setListAdapter(adapter);
	}

	private void handleIntent(Intent intent) {
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);
			doMySearch(query);
		}
	}

	/*
	 * @param do the search according to your query, suppose the query is the
	 * name of the book
	 */
	private void doMySearch(String query) {
		// TODO Auto-generated method stub

		BookViewInfo bookViewOne = new BookViewInfo("first org",
				"first review", R.drawable.testpor1, 1, "bookOneName");
		BookViewInfo bookViewTwo = new BookViewInfo("second org",
				"second review", R.drawable.testpor2, 2, "BookTwoName");

		BookViewInfo[] bookViewArray = { bookViewOne, bookViewTwo };
		searchResult = bookViewArray;
	}

	public void onListItemClick(ListView l, View v, int position, long id) {
		// call detail activity for clicked entry
	}
	
	/*
	 * Should a user start a new search from within your search activity, 
	 * Android would recycle the instance and call the method onNewIntent()
	 *  with the new search intent as its parameter.
	 */
	public void onNewIntent(Intent intent) { 
		setIntent(intent);
		handleIntent(intent);
	}

}
