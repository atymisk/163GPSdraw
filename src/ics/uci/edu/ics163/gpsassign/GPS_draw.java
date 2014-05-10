package ics.uci.edu.ics163.gpsassign;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.IntentSender;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class GPS_draw extends Activity implements 
	GooglePlayServicesClient.ConnectionCallbacks,
	GooglePlayServicesClient.OnConnectionFailedListener,
	LocationListener {
	LocationClient mLocationClient = new LocationClient(this,this,this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps_draw);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		
		
		
	}
	
	private String lastLocation;

	private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
	
	public static class ErrorDialogFragment extends DialogFragment 
	{
		private Dialog mDialog;
		
		public ErrorDialogFragment()
		{
				super();
				mDialog = null;
		}
		
		public void setDialog(Dialog dialog)
		{
			mDialog = dialog;
		}
		public Dialog onCreateDialog(Bundle savedInstanceState)
		{
			return mDialog;
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
		
		public static TextView locationView;
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
					System.out.println("Clicked");
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
	
	private void updateUI()
	{
		runOnUiThread(new Runnable(){
			@Override
			public void run()
			{
				if(PlaceholderFragment.locationView != null && lastLocation != null)
				{
					PlaceholderFragment.locationView.setText(lastLocation);
				}
			}
		});
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
		Log.v("CLICKED", "uploaded");
	}
	
	public static void color1(View v)
	{
		Log.v("CLICKED", "red");	
	}
	public static void color2(View v)
	{
		System.out.println("green");
		Log.v("CLICKED", "green");
	}
	
	public static void color3(View v)
	{
		System.out.println("blue");
		Log.v("CLICKED", "blue");
	}
	
	public static void color4(View v)
	{
		System.out.println("derp");
		Log.v("CLICKED", "derp");
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnectionFailed(ConnectionResult result) 
	{
		if (result.hasResolution())
		{
			try 
			{
				result.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
				
			}
			catch (IntentSender.SendIntentException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(result.getErrorCode(), this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
			
			if (errorDialog != null)
			{
				ErrorDialogFragment errorFragment = new ErrorDialogFragment();
				errorFragment.setDialog(errorDialog);
				errorFragment.show(getFragmentManager(), "Location Updates");
			}
		}
		
		
		
	}

	@Override
	public void onConnected(Bundle connectionHint) {
		Toast.makeText(this, "Connected",Toast.LENGTH_SHORT).show();
		
		Location mCurrentLocation = mLocationClient.getLastLocation();
		lastLocation = "("+mCurrentLocation.getLatitude()+","+mCurrentLocation.getLongitude()+")";
		updateUI();
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}
}
