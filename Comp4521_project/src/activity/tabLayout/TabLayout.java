package activity.tabLayout;


import hkust.comp4521.project.R;
import activity.search.Search;
import activity.social.Social;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class TabLayout extends FragmentActivity implements ActionBar.TabListener
{
	private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    // Tab titles
    private String[] tabs = { "Fresh", "Home", "Pop" };
    

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.whole_page, menu);
		
		 MenuItem menuItem = menu.findItem(R.id.action_circle);
		 SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
		 //SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		 
		 //Assumes current activity is the searchable activity
		 //searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		 //searchView.setIconifiedByDefault(false);
		
		 MenuItemCompat.setOnActionExpandListener(menuItem, new OnActionExpandListener() {
		        @Override
		        public boolean onMenuItemActionCollapse(MenuItem item) {
		            // Do something when collapsed
		        	Toast.makeText(getApplicationContext(), "be collpased", Toast.LENGTH_LONG).show();
		            return true;  // Return true to collapse action view
		        }

		        @Override
		        public boolean onMenuItemActionExpand(MenuItem item) {
		        	Toast.makeText(getApplicationContext(), "expanded", Toast.LENGTH_LONG).show();
		            // Do something when expanded
		            return true;  // Return true to expand action view
		        }
		    });
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.action_search:
	        	Toast.makeText(getApplicationContext(), "searchView", Toast.LENGTH_LONG).show();
	            new Search();
	            return true;
	        case R.id.action_circle:
	            new Social();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout);
 
        // Initialization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
 
        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);        
 
        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
        }
        
        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
         
            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }
         
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
         
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
}
