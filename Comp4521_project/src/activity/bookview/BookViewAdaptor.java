package activity.bookview;

import java.util.ArrayList;

import hkust.comp4521.project.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BookViewAdaptor extends ArrayAdapter<BookViewInfo> {

	private final Context context;
	private final ArrayList<String> originalText;
	private final ArrayList<String> reviewText;
	private final ArrayList<Integer> portrait;
	private final ArrayList<Integer> bookid;
	private final ArrayList<String> bookname;


	public BookViewAdaptor(Context context, BookViewInfo[] info) {
		super(context, R.layout.fragment_bookview, info);
		//extract information
		this.context = context;
		
		this.originalText = new ArrayList<String>();
		this.reviewText = new ArrayList<String>();
		this.portrait = new ArrayList<Integer>();
		this.bookid = new ArrayList<Integer>();
		this.bookname = new ArrayList<String>();
		
		for(int i = 0; i < info.length;++i) {
			originalText.add(info[i].getOriginalText());
			reviewText.add(info[i].getReviewText());
			portrait.add(info[i].getImageId());
			bookid.add(info[i].getBookId());
			bookname.add(info[i].getBookname());
		}
		
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.fragment_bookview, parent,
				false);
		TextView textView = (TextView) rowView.findViewById(R.id.firstLine);
		TextView textView2 = (TextView) rowView.findViewById(R.id.secondLine);
		TextView textView3 = (TextView) rowView.findViewById(R.id.bookname);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		
		textView.setText(originalText.get(position));
		textView2.setText(reviewText.get(position));
		textView3.setText(bookname.get(position));
		imageView.setImageResource(portrait.get(position));

		return rowView;
	}

}
