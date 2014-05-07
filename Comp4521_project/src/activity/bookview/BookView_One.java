package activity.bookview;


import mockData.MockData;
import hkust.comp4521.project.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
 
public class BookView_One extends Activity {
 
	TextView textView;
	TextView textView2;
	TextView textView3;
	TextView textView4;
	ImageView imageView;
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		setContentView(R.layout.fragment_bookview_total);
         
        textView = (TextView) findViewById(R.id.firstLine);
		textView2 = (TextView) findViewById(R.id.secondLine);
		textView3 = (TextView) findViewById(R.id.bookname);
		textView4 = (TextView) findViewById(R.id.bookid);
		imageView = (ImageView) findViewById(R.id.icon);
		

		model.BookView info = MockData.BookView.sample1;
		textView.setText(info.refText);
		textView2.setText(info.content);
		textView3.setText(MockData.Book.sample1.name);
		textView4.setText(MockData.Book.sample1.ISBN);
		//imageView.
    }
}