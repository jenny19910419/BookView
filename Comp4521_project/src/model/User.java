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
					Log.d(TAG, "list_following returns a non-array object");
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
}