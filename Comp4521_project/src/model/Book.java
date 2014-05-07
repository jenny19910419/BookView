package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import myUtil.Callable;
import myUtil.Server;

public class Book extends Data
{
	public static final String TAG = "Book";
	public String name = "";
	public String preview = "";
	public String author = "";
	public String ISBN = "";
	
	/**
	 * search books with a string
	 * @param query
	 * @param callback
	 */
	public static void server_search(String query, final Callable callback) {
		Server.post("Book/search", new String[]{query}, new Callable() {

			@Override
			public void callback(Object d) {
				// TODO Auto-generated method stub
				if(! (d instanceof JSONArray)) {
					Log.e(TAG, "server_search returns a non-array object");
					callback.callback(null);
				}
				
				Book[] rtn = Data.from_json_arr(Book.class, (JSONArray)d);
				callback.callback(rtn);
			}
			
		});
	}
	/**
	 * list the book-views of this book
	 * @param callback
	 */
	public void server_list_book_view(final Callable callback) {
		Server.post("Book/list_book_view", new String[]{this.get_ptr()}, new Callable() {

			@Override
			public void callback(Object d) {
				BookView[] res = Data.from_json_arr(BookView.class, (JSONArray) d);
				callback.callback(res);
			}
			
		});
	}
}
