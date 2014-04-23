package activity.bookview;


import hkust.comp4521.project.R;
import MockBookViewList.MockBookViewList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
 
public class BookView_One extends Fragment {
 
	TextView textView;
	TextView textView2;
	TextView textView3;
	TextView textView4;
	ImageView imageView;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_bookview_total, container, false);
         
        textView = (TextView) rootView.findViewById(R.id.firstLine);
		textView2 = (TextView) rootView.findViewById(R.id.secondLine);
		textView3 = (TextView) rootView.findViewById(R.id.bookname);
		textView4 = (TextView) rootView.findViewById(R.id.bookid);
		imageView = (ImageView) rootView.findViewById(R.id.icon);
		
		/*Bundle bundle = getArguments();
		String detail = bundle.getString("KEY_DETAIL", "no argument pass");
	    textDetail.setText(detail);*/
		
		MockBookViewList mkbookviewlist = new MockBookViewList();
		BookViewInfo info=mkbookviewlist.bookViewArray[1];
		textView.setText(info.getOriginalText());
		textView2.setText(info.getReviewText());
		textView3.setText(info.getBookname());
		textView4.setText(info.getBookId());
		imageView.setImageResource(info.getImageId());
        return rootView;
    }
}