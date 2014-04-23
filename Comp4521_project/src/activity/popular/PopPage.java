package activity.popular;

import hkust.comp4521.project.R;
import MockBookViewList.MockBookViewList;
import activity.bookview.BookViewAdaptor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
 
public class PopPage  extends Fragment {
	 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	View rootView = inflater.inflate(R.layout.fragment_poppage, container, false);
    
        return rootView;
    }
 }
