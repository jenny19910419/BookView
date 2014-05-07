package activity.fresh;

import java.util.Observable;
import java.util.Observer;

import mockData.MockData;
import model.User;
import hkust.comp4521.project.R;
import activity.bookview.BookViewAdaptor;
import activity.bookview.BookViewInfo;
import activity.bookview.BookView_One;
import activity.bookview.TestAdapter;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import myUtil.Callable;

public class FreshPage extends ListFragment implements Observer
{
	private static final String TAG = "FreshPage";
	private FreshPage_Ctrl ctrl = new FreshPage_Ctrl();
	private Handler handler = new Handler();
	
	@Override
	  public void onActivityCreated(Bundle savedInstanceState) {
	    super.onActivityCreated(savedInstanceState);
	    
	    ctrl.addObserver(this);
	    
	    ctrl.refresh();
	    
	    
	  }
	
	
	 @Override
	public void onListItemClick(ListView l, View v, int position, long id) {
	    model.BookView item = (model.BookView) getListAdapter().getItem(position);
	    //Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
        
	    Intent in = new Intent(getActivity().getApplicationContext(),BookView_One.class);
	    FreshPage.this.startActivity(in);
         
	 }
	
	


	@Override
	public void update(Observable observable,final Object state) {
		handler.post(new Runnable() {

			@Override
			public void run() {
				FreshPage.this.update_sync(state);
			}
			
		});
	}
	
	public void update_sync(Object state) {
		switch((Integer) state) {
		case FreshPage_Ctrl.State.loading:
			ArrayAdapter simpleAdapter = new ArrayAdapter(getActivity(),R.layout.text,new String[]{"loading..."});
			this.setListAdapter(simpleAdapter);
			break;
		case FreshPage_Ctrl.State.ready:
			BookViewAdaptor adapter = new BookViewAdaptor(getActivity(),
		    		this.ctrl.bookViewArr, this.ctrl.relatedBookArr, this.ctrl.relatedUserArr);
		
		    setListAdapter(adapter);
		}
	}

}