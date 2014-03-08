package Data;

import org.json.JSONObject;

import myUtil.Callable;
import myUtil.Server;

public class User extends Data
{
	public String email = "";
	private static User currUser = null;
	public static void server_login(String email, String password, final Callable callback) {
		Server.post("User/login", new String[]{email, password}, new Callable() {

			@Override
			public void callback(Object d) {
				if(d == null) {
					callback.callback(null);
				}
				else {
					User user = (User)Data.from_json((JSONObject)d);
					User.currUser = user;
					callback.callback(user);
				}
				
			}
			
		});
		
	}
}