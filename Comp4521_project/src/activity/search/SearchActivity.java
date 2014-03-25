package activity.search;

import hkust.comp4521.project.R;
import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

public class SearchActivity extends ListActivity {
	
	
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

}
