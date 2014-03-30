package model;

import org.json.JSONObject;

import android.util.Log;

import myUtil.Callable;
import myUtil.Server;

public class BookView extends Data
{
	public static final String TAG = "Data";
	public String authorPtr = "";
	public String bookPtr = "";
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
}
