package activity.social;

import java.util.Observable;

import model.User;
import myUtil.Callable;
import activity.fresh.FreshPage_Ctrl;

public class ListBookBuddy_Ctrl extends Observable{

	public final static String TAG = "ListBookBuddy_Ctrl";
	public final static class State {
		public final static int loading = 1;
		public final static int ready = 2;
	}
	
	public model.User[] relatedUserArr = null;
	
	public ListBookBuddy_Ctrl() {
		
	}
	
	public void refresh() {
		this.setChanged();
		this.notifyObservers(ListBookBuddy_Ctrl.State.loading);
		
		User.server_get_fresh(5, 0, new Callable() {

			@Override
			public void callback(Object d) {
				User.GetFreshResult res = (User.GetFreshResult)d;
				ListBookBuddy_Ctrl.this.relatedUserArr = res.relatedUserArr;
				
				ListBookBuddy_Ctrl.this.setChanged();
				ListBookBuddy_Ctrl.this.notifyObservers(ListBookBuddy_Ctrl.State.ready);
			}
			
		});
		
		
	}
	
	
}
