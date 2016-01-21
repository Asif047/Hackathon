
//this activity is for difficulty-HARD


package com.asiftanmoy.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivity extends Activity {
	
	

	Button oneplayerButton;
	Button twoplayerButton;
	MediaPlayer mp6;
	MediaPlayer mp7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		 //removing the title
	      requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		
		setContentView(R.layout.activity_start);
		
		oneplayerButton=(Button) findViewById(R.id.onePlayer_button);
		
		twoplayerButton=(Button) findViewById(R.id.twoPlayer_button);
		
		mp6=MediaPlayer.create(this, R.raw.one_player_click);
		mp7=MediaPlayer.create(this, R.raw.two_player_click);
		
			
oneplayerButton.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		
		
		if(DifficultyActivity.difficulty_selector==1)
		{
		
			//for sound
			if(SoundActivity.sound_selector!=1)
			{
				mp6.start();
			}
			
			
		Intent gameIntent=new Intent(StartActivity.this,TicTacToeActivity4.class);
		startActivity(gameIntent);
		
		}
		
		
		else if(DifficultyActivity.difficulty_selector==3)
		{
		
			//for sound
			if(SoundActivity.sound_selector!=1)
			{
				mp6.start();
			}
			
			
		Intent gameIntent=new Intent(StartActivity.this,TicTacToeActivity3.class);
		startActivity(gameIntent);
		
		}
		
		else
		{
			
			//for sound
			if(SoundActivity.sound_selector!=1)
			{
				mp6.start();
			}
			
			
			Intent gameIntent=new Intent(StartActivity.this,TicTacToeActivity.class);
			startActivity(gameIntent);
			
		}
		
		// TODO Auto-generated method stub
		
	}
});



twoplayerButton.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		
		
		//for sound
		if(SoundActivity.sound_selector!=1)
		{
			mp7.start();
		}
		
		
		Intent gameIntent=new Intent(StartActivity.this,TicTacToeActivity2.class);
		startActivity(gameIntent);
		
		// TODO Auto-generated method stub
		
	}
});

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start, menu);
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
