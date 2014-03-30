package activity.bookview;

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


public class BookViewAdaptor extends ArrayAdapter<String>{
	
	private final Context context;
	private final String[] originalText;
	private final String[] reviewText;
	private final int[] portrait;

	public BookViewAdaptor(Context context, String[] values,String[] reviewText,int[] porId) {
		super(context, R.layout.fragment_bookview, values);
		this.context = context;
		this.originalText = values;
		this.reviewText = reviewText;
		this.portrait = porId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.fragment_bookview, parent,
				false);
		TextView textView = (TextView) rowView.findViewById(R.id.firstLine);
		TextView textView2 = (TextView) rowView.findViewById(R.id.secondLine);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		textView.setText(originalText[position]);
		textView2.setText(reviewText[position]);
		imageView.setImageResource(portrait[position]);
		

		return rowView;
	}
	

}
