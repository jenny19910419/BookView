package model;

import java.lang.reflect.Field;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Data
{
	protected String _thisPtr = "";
	private static String PACKAGE_PATH = "Data";
	
	/**
	 * construct a Data Object from a JSON returned by server.
	 * @param jObject the JSON returned by server
	 * @return the parsed Data object. returns null if parsing fails.
	 */
	public static Data from_json(JSONObject jObject) {
		final String TAG = "Data.from_json";
		String className = "";
		Data rtn = null;

		// get class name
		try {
			className = jObject.getString("_className");
		} catch (JSONException e) {
			Log.d(TAG,"_className not found");
			return null;
		}

		// get class from class name
		Class<?> theClass = null;
		try {
			theClass = Class.forName(Data.PACKAGE_PATH + "." + className);
		} catch (ClassNotFoundException e) {
			Log.d(TAG,"class not found");
			return null;
		}

		// construct object
		Object _rtn = null;
		try {
			_rtn = theClass.newInstance();
		} catch (Exception e) {
			Log.d(TAG,"error creating instance");
			return null;
		}
		
		// verify it is Data and assign _thisPtr
		if(!(_rtn instanceof Data)) {
			Log.d(TAG,"class not an instance of Data");
			return null;
		}
		
		rtn = (Data)_rtn;
		try {
			rtn._thisPtr = jObject.getString("_thisPtr");
		} catch (JSONException e2) {
			
		}
		
		

		// traverse JSON fields
		Iterator<?> keys = jObject.keys();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			if (key.equals("_className"))
				continue;
			if (key.equals("_thisPtr"))
				continue;
			

			// get field from rtn Data
			Field field = null;
			try {
				field = theClass.getDeclaredField(key);
			} catch (NoSuchFieldException e1) {
				continue;
			} catch (SecurityException e1) {
				Log.d(TAG,"security exception");
				continue;
			}

			// get value from JSON
			Object value = null;
			try {
				value = jObject.get(key);
			} catch (JSONException e) {
				e.printStackTrace();
				continue;
			}
			
			// set value to rtn Data
			try {
				field.set(rtn, Data.parse_json_value(value));
				
			} catch (Exception e) {
				Log.d(TAG,"error setting field: " + key);
				continue;
			}

		}

		return rtn;
	}

	private static Object parse_json_value(Object value) {
		if (value instanceof String || value instanceof Integer) {
			return value;
		} else if (value instanceof JSONArray) {
			JSONArray arr = (JSONArray) value;
			String[] rtn = new String[arr.length()];
			for (int i = 0; i < arr.length(); i++) {
				try {
					rtn[i] = (String)parse_json_value(arr.get(i));
				} catch (JSONException e) {
					rtn[i] = null;
				}
			}
			return rtn;
		} else {
			return null;
		}
	}
	/**
	 * get the pointer of the data. the pointer is used in server communication.
	 * @return pointer of the data
	 */
	public String get_ptr() {
		return this._thisPtr;
	}
}
