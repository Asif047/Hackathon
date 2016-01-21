package com.asiftanmoy.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OptionActivity extends Activity {
	
	

	Button selecticonButton;
	Button difficultyButton;
	Button soundButton;
	
	
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		 //removing the title
	      requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		
		
		setContentView(R.layout.activity_option);
		
		
		selecticonButton=(Button) findViewById(R.id.selecticon_button);
		
		difficultyButton=(Button) findViewById(R.id.difficulty_button);
		
		soundButton=(Button) findViewById(R.id.sound_button);
		
		
		
		selecticonButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent gameIntent=new Intent(OptionActivity.this,SelecticonActivity.class);
				startActivity(gameIntent);
			}
		});
		
		
		
		difficultyButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent gameIntent=new Intent(OptionActivity.this,DifficultyActivity.class);
				startActivity(gameIntent);
				
			}
		});
		
		
		soundButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent gameIntent=new Intent(OptionActivity.this,SoundActivity.class);
				startActivity(gameIntent);
				
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.option, menu);
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
