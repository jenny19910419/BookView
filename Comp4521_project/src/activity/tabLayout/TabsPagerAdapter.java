package activity.tabLayout;

import activity.bookview.BookView;
import activity.search.Search;
import activity.social.Social;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
 
public class TabsPagerAdapter extends FragmentPagerAdapter {
 
    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }
 

	@Override
    public Fragment getItem(int index) {
 
        switch (index) {
        case 0:
            return new BookView();
        case 1:
            return new Social();
        case 2:
            return new Search();
        }
 
        return null;
    }
 
    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
 
}