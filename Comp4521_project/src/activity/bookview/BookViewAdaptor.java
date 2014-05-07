package activity.bookview;

import java.util.ArrayList;

import mockData.MockData;
import model.Data;

import hkust.comp4521.project.R;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BookViewAdaptor extends ArrayAdapter<model.BookView> {
	
	public static final String TAG = "BookViewAdapter";

	private final Context context;
	private final ArrayList<String> originalText;
	private final ArrayList<String> reviewText;
	private final ArrayList<Drawable> portrait;
	private final ArrayList<String> bookid;
	private final ArrayList<String> bookname;

	public BookViewAdaptor(Context context, model.BookView[] bookViewArr, model.Book[] relatedBookArr) {
		this(context, bookViewArr, relatedBookArr, null);
	}
	
	public BookViewAdaptor(Context context, model.BookView[] bookViewArr, model.Book[] relatedBookArr, model.User[] relatedUserArr) {
		super(context, R.layout.fragment_bookview, bookViewArr);
		
		//extract information
		this.context = context;
		
		this.originalText = new ArrayList<String>();
		this.reviewText = new ArrayList<String>();
		this.portrait = new ArrayList<Drawable>();
		this.bookid = new ArrayList<String>();
		this.bookname = new ArrayList<String>();
		
	
		
		for(int i = 0; i < bookViewArr.length;++i) {
			model.BookView bookView = bookViewArr[i];
			
			// related book
			model.Book book = Data.get_data_from_array(relatedBookArr, bookView.bookPtr);
			
			// related user
			
			originalText.add(bookView.content);
			reviewText.add(bookView.refText);
			
			// get book name, book ISBN from related book
			if(book != null) {
				bookid.add(book.ISBN);
				bookname.add(book.name);
			}
			else {
				bookid.add("");
				bookname.add("");
			}
			
			// get user image from related user
			if(relatedUserArr != null) {
				model.User user = Data.get_data_from_array(relatedUserArr, bookView.authorPtr);
				BitmapDrawable d = new BitmapDrawable(context.getResources(), user.get_image());
				portrait.add(d);
			}
			else {
				portrait.add(context.getResources().getDrawable(R.drawable.testpor1));
			}
			
			
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
		
		if(originalText.get(position).length()>15){
		    textView.setText(originalText.get(position).substring(0, 15));
		}
		else{
			textView.setText(originalText.get(position));
		}
		if(reviewText.get(position).length()>15){
		    textView2.setText(reviewText.get(position).substring(0, 15));
		}
		else{
			textView2.setText(reviewText.get(position));
		}
		if(bookname.get(position).length()>20){
		    textView3.setText(bookname.get(position).substring(0, 20));
		}
		else{
			textView3.setText(bookname.get(position));
		}
		imageView.setImageDrawable(portrait.get(position));

		return rowView;
	}

}
