package model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import myUtil.Callable;
import myUtil.Server;

public class User extends Data
{
	public static final String TAG = "User";
	public String email = "";
	public String name = "";
	
	private static User activeUser = null;
	/**
	 * perform a login action
	 * @param email the email of the user
	 * @param password the password of the user
	 * @param callback will be called when login completes.
	 * 
	 * callback function
	 * @param {User} the logged in user. will be null if login fails.
	 * 
	 */
	public static void server_login(String email, String password, final Callable callback) {
		Server.post("User/login", new String[]{email, password}, new Callable() {
			@Override
			public void callback(Object d) {
				if(d == null) {
					callback.callback(null);
				}
				else {
					User user = (User)Data.from_json((JSONObject)d);
					User.activeUser = user;
					callback.callback(user);
				}
				
			}
			
		});
		
	}
	/**
	 * retrieve all followers of current user.
	 * @param callback will be called when finished retrieving.
	 * 
	 * callback function
	 * @param {User[]} the list of followers
	 */
	public static void server_list_follower(final Callable callback) {
		Server.post("User/list_follower", new String[]{}, new Callable() {

			@Override
			public void callback(Object d) {
				if(! (d instanceof JSONArray)) {
					Log.d(TAG, "list_follower returns a non-array object");
					callback.callback(null);
				}
				
				JSONArray arr = (JSONArray)d;
				User[] rtn = new User[arr.length()];
				for(int i=0;i<arr.length();i++) {
					try {
						rtn[i] = (User)Data.from_json((JSONObject)arr.get(i));
					} catch (JSONException e) {
						rtn[i] = null;
					}
				}
				callback.callback(rtn);
			}
			
		});
	}
	/**
	 * retrieve all followings of current user.
	 * @param callback will be called when finished retrieving.
	 * 
	 * callback function
	 * @param {User[]} the list of followings
	 */
	public static void server_list_following(final Callable callback) {
		Server.post("User/list_following", new String[]{}, new Callable() {

			@Override
			public void callback(Object d) {
				if(! (d instanceof JSONArray)) {
					Log.e(TAG, "list_following returns a non-array object");
					callback.callback(null);
				}
				
				JSONArray arr = (JSONArray)d;
				User[] rtn = new User[arr.length()];
				for(int i=0;i<arr.length();i++) {
					try {
						rtn[i] = (User)Data.from_json((JSONObject)arr.get(i));
					} catch (JSONException e) {
						rtn[i] = null;
					}
				}
				callback.callback(rtn);
			}
			
		});
	}
	/**
	 * let the active user follow another user
	 * @param userPtr the target user pointer
	 * @param callback 
	 */
	public static void server_add_following(String userPtr, final Callable callback) {
		Server.post("User/add_following", new String[]{userPtr}, new Callable() {

			@Override
			public void callback(Object d) {
				if(d == null) {
					Log.d(TAG, "add_following fails");
					callback.callback(null);
					return;
				}
				
				callback.callback(Data.from_json((JSONObject) d));
			}
			
		});
	}
	/**
	 * get the current active user
	 * @return active user
	 */
	public static User get_active_user() {
		return User.activeUser;
	}
	
	/**
	 * get the fresh informations of active user
	 * @param bookViewCnt maximum book-view number
	 * @param commentCnt maximum comment number
	 * @param callback
	 */
	public static void server_get_fresh(int bookViewCnt, int commentCnt, final Callable callback) {
		Server.post("User/get_fresh", new String[]{Integer.toString(bookViewCnt), Integer.toString(commentCnt)}, new Callable() {

			@Override
			public void callback(Object d) {
				JSONObject res = (JSONObject)d;
				JSONArray bookViewJsonArr = null;
				JSONArray commentJsonArr = null;
				JSONArray relatedBookJsonArr = null;
				JSONArray relatedBookViewJsonArr = null;
				JSONArray relatedUserJsonArr = null;
				try {
					bookViewJsonArr = res.getJSONArray("bookViewArr");
					commentJsonArr = res.getJSONArray("commentArr");
					
					relatedBookJsonArr = res.getJSONArray("relatedBookArr");
					relatedBookViewJsonArr = res.getJSONArray("relatedBookViewArr");
					relatedUserJsonArr = res.getJSONArray("relatedUserArr");
				} catch (JSONException e) {
					Log.e(TAG, "get_fresh bad response");
					callback.callback(null);
					return;
				}
				
				GetFreshResult rtn = new GetFreshResult();
				rtn.bookViewArr = Data.from_json_arr(BookView.class, bookViewJsonArr);
				rtn.commentArr = Data.from_json_arr(BookView_Comment.class, commentJsonArr);
				rtn.relatedBookArr = Data.from_json_arr(Book.class, relatedBookJsonArr);
				rtn.relatedBookViewArr = Data.from_json_arr(BookView.class, relatedBookViewJsonArr);
				rtn.relatedUserArr = Data.from_json_arr(User.class, relatedUserJsonArr);
				
				callback.callback(rtn);
				
			}
			
			
		});
	}
	public static class GetFreshResult
	{
		public BookView[] bookViewArr; // fresh book-views: the book-view that your followings posted
		public BookView_Comment[] commentArr; // fresh comments: you book-view has received a comment
		public Book[] relatedBookArr; // the books referenced in fresh book-views
		public BookView[] relatedBookViewArr; // the book-view referenced in the fresh comments
		public User[] relatedUserArr; // the users related in fresh book-views and fresh comments
		
	}
	/**
	 * edit the active user
	 * @param name
	 * @param password
	 */
	public static void server_put(String name, String password, final Callable callback) {
		Server.post("User/put", new String[]{name,password}, new Callable() {

			@Override
			public void callback(Object d) {
				User res = (User)d;
				User activeUser = User.get_active_user();
				activeUser.name = res.name;
				callback.callback(activeUser);
				
			}
			
		});
	}
	
	
}