package com.asiftanmoy.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;

public class SelecticonActivity extends Activity {

	static int icon_selector;
	static int icon_selector2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		 //removing the title
	      requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		
		
		setContentView(R.layout.activity_selecticon);
	}
	
	
	
	public void select(View v)
	{
		boolean check=((RadioButton)v).isChecked();
		
		switch(v.getId())
		{
		
		case R.id.radioButton1:
			if(check)
			{
				icon_selector=1;
			}
			break;
			
		case R.id.radioButton2:
			if(check)
			{
				icon_selector=2;
			}
			
			default:
				break;
		
		}
		
	}
	
	
	
	public void select2(View v)
	{
		boolean check=((RadioButton)v).isChecked();
		
		switch(v.getId())
		{
		
		case R.id.radioButton3:
			if(check)
			{
				icon_selector2=3;
			}
			break;
			
		case R.id.radioButton4:
			if(check)
			{
				icon_selector2=4;
			}
			
			default:
				break;
		
		}
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selecticon, menu);
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
