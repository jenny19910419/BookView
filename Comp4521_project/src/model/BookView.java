package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import myUtil.Callable;
import myUtil.Server;

public class BookView extends Data
{
	public static final String TAG = "Data";
	public String authorPtr = "";
	public String bookPtr = "";
	public String refText = "";
	public String content = "";
	public long createTime = 0;
	
	/**
	 * fetch a BookView from server by its pointer
	 * 
	 * @param ptr the pointer of the BookView
	 * @param callback 
	 * 
	 * callback
	 * @param {BookView}
	 */
	public static void server_get(String ptr, final Callable callback) {
		Server.post("BookView/get", new String[]{ptr}, new Callable() {

			@Override
			public void callback(Object d) {
				if(!(d instanceof JSONObject)) {
					Log.e(TAG, "an error occurred");
					callback.callback(null);
					return;
				}
				BookView rtn = (BookView)Data.from_json((JSONObject)d);
				
				callback.callback(rtn);
				
			}
			
		});
	}
	/**
	 * upload the change of this book-view.
	 * @param bookPtr the pointer of book
	 * @param refText the text referenced in the book, filled by user
	 * @param content the content of the book-view
	 * @param callback
	 * 
	 * callback
	 * @param {BookView} this
	 */
	public void server_put(final Callable callback ) {
		final BookView that = this;
		Server.post("BookView/put", new String[]{this.get_ptr(), this.bookPtr, this.refText, this.content}, new Callable() {

			@Override
			public void callback(Object d) {
				
				BookView rtn = (BookView) Data.from_json((JSONObject)d);
				if(rtn == null) {
					callback.callback(null);
				}
				else {
					that._thisPtr = rtn.get_ptr();
					that.createTime = rtn.createTime;
					callback.callback(this);
				}
				
				
			}
			
		});
	}
	
	/**
	 * list the comment of this book-view
	 * @param callback
	 * 
	 * callback
	 * @param {ListCommentResult}
	 */
	public void server_list_comment(final Callable callback) {
		Server.post("BookView/list_comment", new String[]{this.get_ptr()}, new Callable() {

			@Override
			public void callback(Object d) {
				if(! (d instanceof JSONArray)) {
					Log.e(TAG, "list_comment returns a non-array object");
					callback.callback(null);
					return;
				}
				
				
				JSONObject res = (JSONObject)d;
				JSONArray commentJsonArr = null;
				JSONArray relatedUserJsonArr = null;
				try {
					commentJsonArr = res.getJSONArray("commentArr");
					relatedUserJsonArr = res.getJSONArray("relatedUserArr");
				} catch (JSONException e) {
					Log.e(TAG, "list_comment bad response");
					callback.callback(null);
					return;
				}
				
				ListCommentResult rtn = new ListCommentResult();
				rtn.commentArr = Data.from_json_arr(BookView_Comment.class, commentJsonArr);
				rtn.relatedUserArr = Data.from_json_arr(User.class, relatedUserJsonArr);
				callback.callback(rtn);
				
				
			}
			
		});
	}
	public static class ListCommentResult {
		public BookView_Comment[] commentArr;
		public User[] relatedUserArr;
	}
}
