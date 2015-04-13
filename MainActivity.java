package com.example.ecocar2;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

// This is the Main Activity that gets launched
// OnCreate is first called to perform initial UI layout - 2 buttons and a introduction fragment
public class MainActivity extends ActionBarActivity {
	
	private Fragment monitor_fr;
	private Fragment control_fr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
		    
	
// This selectFrag is associated with the 2 main buttons to select which fragment gets displayed.
// The 2 buttons in the activity_main.xml contain a button click event to call selectFrag.
	 public void selectFrag(View view) {
		 Fragment fr;
		 if(view == findViewById(R.id.button2)) {
			 if(monitor_fr != null){
				fr = monitor_fr; 
			 }
			 else{
				 fr = new monitor();
				 monitor_fr = fr;
			 }             
		 }else {
			 if(control_fr != null){
				 fr = control_fr;
			 }
			 else{
				 fr = new control();
				 control_fr = fr;
			 }
		 }
				 	 
		 FragmentManager fm = getFragmentManager();
		 FragmentTransaction fragmentTransaction = fm.beginTransaction();
		 fragmentTransaction.replace(R.id.fragment_place, fr);
		 // fragmentTransaction.addToBackStack(null); Don't use since no back button so old fragment is destroyed 
		 fragmentTransaction.commit();
				 
	 }

//Options Menu are place holder for top of screen
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
// Main activity resume
	@Override
    public void onResume() {
	     super.onResume();
	}
}
