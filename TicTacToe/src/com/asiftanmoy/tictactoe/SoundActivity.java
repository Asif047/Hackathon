package com.asiftanmoy.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

public class SoundActivity extends Activity {

	
	static int sound_selector;
	
	
	public void select(View v)
	{
		boolean check=((RadioButton)v).isChecked();
		
		switch(v.getId())
		{
		
		case R.id.sound_on_button:
			
			if(check)
			{
				sound_selector=2;
			}
			break;
			
		case R.id.sound_off_button:
			if(check)
			{
				sound_selector=1;
			}
			
			
			default:
				break;
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		
		 //removing the title
	      requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		
		
		setContentView(R.layout.activity_sound);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sound, menu);
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
}
