package myUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;


public class Server
{
	private static String SERVER_URL = "http://node.citethrough.com:18080/";

	public static void post(final String path, final String[] args, final Callable callback) {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				Object j = Server.postSync(path, args);
				callback.callback(j);
				
			}
			
		});
		thread.start();
	}

	public static JSONObject postSync(String path, String[] args) {
		final String TAG = "Server.postSync";
		// assemble url parameters
		String urlParameters;
		urlParameters = "param="
				+ Str.encodeURIComponent(Server.string_arr_encode(args));
	

		// assemble request url
		String request = Server.SERVER_URL + path;

		URL url;
		try {
			url = new URL(request);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
		HttpURLConnection connection = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Log.d(TAG, "IO Exception");
			return null;
		}
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setInstanceFollowRedirects(false);
		try {
			connection.setRequestMethod("POST");
		} catch (ProtocolException e) {
			Log.d(TAG, "Protocol Exception");
			return null;
		}
		connection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		connection.setRequestProperty("charset", "utf-8");
		connection.setRequestProperty("Content-Length",
				"" + Integer.toString(urlParameters.getBytes().length));
		connection.setUseCaches(false);


		DataOutputStream wr = null;
		try {
			wr = new DataOutputStream(
					connection.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
		} catch (IOException e1) {
			Log.d(TAG, "Write Exception");
			return null;
		}


		String response = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			String current;
			while ((current = in.readLine()) != null) {
				response += current;
			}
		} catch (IOException e2) {
			Log.d(TAG, "Read Exception");
			return null;
		}

		JSONObject rtn;
		Log.d(TAG, response);
		try {
			rtn = new JSONObject(response);
		} catch (JSONException e) {
			
			return null;
		}
		return rtn;
	}
	
	private static String string_arr_encode(String[] arr) {
		String[] toImplode = new String[arr.length];
		for(int i=0;i<arr.length;i++) {
			toImplode[i] = "\"" + arr[i].replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
		}
		return "[" + Str.join(toImplode, ",") + "]";
		
	}

	

}
