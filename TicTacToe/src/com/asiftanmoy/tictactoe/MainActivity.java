package com.asiftanmoy.tictactoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity<HomeScreen> extends Activity {
	
	
	Button startButton;
	Button instructionsButton;
	Button developersButton;
	Button optionButton;
	Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        //removing the title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        
        setContentView(R.layout.activity_main);
        
        startButton=(Button) findViewById(R.id.start_button);
        instructionsButton=(Button) findViewById(R.id.instructions_button);
        developersButton= (Button) findViewById(R.id.developers_button);
        optionButton=(Button)findViewById(R.id.options_button);
       
        
        
        startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// Start Button
				Intent startButtonIntent=new Intent(MainActivity.this,StartActivity.class);
				startActivity(startButtonIntent);
				
				
			}
		});
        
        
        instructionsButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// Instructions Activity
				Intent instructionsIntent=new Intent(MainActivity.this,InstructionsActivity.class);
				startActivity(instructionsIntent);
			}
		});
        
        
        developersButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// developers 
				
				Intent deveIntent=new Intent(MainActivity.this,DevelopersActivity.class);
				startActivity(deveIntent);
				
			}
		});
        
        
 optionButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// developers 
				
				Intent optionIntent=new Intent(MainActivity.this,OptionActivity.class);
				startActivity(optionIntent);
				
			}
		});
        
        
 

        
        
     
        
    }


    
    
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
               .setMessage("Are you sure you want to exit?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
                   }
               })
               .setNegativeButton("No", null)
               .show();
    }
    
    
    
    
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
}
