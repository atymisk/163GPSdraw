package ics.uci.edu.ics163.gpsassign;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.os.Build;

public class GPS_draw extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps_draw);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gps_draw, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		
		private boolean p = false;
		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_gps_draw,
					container, false);
			
			TextView coord = (TextView)rootView.findViewById(R.id.textView3);
			coord.setOnClickListener(new View.OnClickListener() 
			{
				@Override
				public void onClick(View arg0) 
				{
					
				}
			});;
			
			Button up = (Button)rootView.findViewById(R.id.button1);
			up.setOnClickListener(new View.OnClickListener() 
			{
				@Override
				public void onClick(View arg0) 
				{
					upload(arg0);
				}
			});
			
			Button pen = (Button)rootView.findViewById(R.id.button2);
			pen.setOnClickListener(new View.OnClickListener() 
			{	
				@Override
				public void onClick(View arg0) 
				{
					if(p)
						p=false;
					else
						p=true;
					penClick(arg0, p);
				}
			});
			
			RadioButton c1 = (RadioButton)rootView.findViewById(R.id.radioButton1);
			c1.setOnClickListener(new View.OnClickListener() 
			{
				@Override
				public void onClick(View arg0) {
					color1(arg0);
				}
			});
			
			RadioButton c2 = (RadioButton)rootView.findViewById(R.id.radioButton2);
			c2.setOnClickListener(new View.OnClickListener() 
			{
				@Override
				public void onClick(View arg0) 
				{
					color2(arg0);
				}
			});
			
			RadioButton c3 = (RadioButton)rootView.findViewById(R.id.radioButton3);
			c3.setOnClickListener(new View.OnClickListener() 
			{
				@Override
				public void onClick(View arg0) 
				{
					color3(arg0);
				}
			});
			
			RadioButton c4 = (RadioButton)rootView.findViewById(R.id.radioButton4);
			c4.setOnClickListener(new View.OnClickListener() 
			{
				@Override
				public void onClick(View arg0) 
				{
					color4(arg0);
				}
			});
			
			return rootView;
		}
	}
	
	public static void penClick(View v, boolean pen)
	{
		if(pen)
			System.out.println("pen");
		else
			System.out.println("no pen");
	}
	
	public static void upload(View v)
	{
		System.out.println("uploaded");
	}
	
	public static void color1(View v)
	{
		System.out.println("red");	
	}
	public static void color2(View v)
	{
		System.out.println("green");
	}
	
	public static void color3(View v)
	{
		System.out.println("blue");
	}
	
	public static void color4(View v)
	{
		System.out.println("derp");
	}
}
