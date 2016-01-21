package com.asiftanmoy.tictactoe;

import android.R.color;
import android.app.Activity;  
import android.graphics.Color;  
import android.media.MediaPlayer;
import android.os.Bundle;  
import android.view.View;  
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;  
import android.widget.TextView;  
    
    
  public class TicTacToeActivity3 extends Activity {  
         
	  
	  
	  Button playAgainButton;
	  
	  
	  //for the sound
	  MediaPlayer mp;
	  MediaPlayer mp2;
	  MediaPlayer mp3;
	  MediaPlayer mp4;
	  MediaPlayer mp5;
	  
	  
       private TicTacToeGame Game;  
         
       private Button BoardButtons[];  
         
       private TextView InfoTextView;  
       private TextView HumanCount;  
       private TextView TieCount;  
      private TextView AndroidCount;  
         
       private int HumanCounter = 0;  
       private int TieCounter = 0;  
       private int AndroidCounter = 0;  
         
       private boolean HumanFirst = true;  
       private boolean GameOver = false;  
         
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
      super.onCreate(savedInstanceState); 
      
      
      
      
      //removing the title
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      
      
      
      setContentView(R.layout.activity_tic_tac_toe_activity3);  
        
      BoardButtons = new Button[Game.getBOARD_SIZE()];  
      BoardButtons[0] = (Button) findViewById(R.id.one);  
      BoardButtons[1] = (Button) findViewById(R.id.two);  
      BoardButtons[2] = (Button) findViewById(R.id.three);  
      BoardButtons[3] = (Button) findViewById(R.id.four);  
      BoardButtons[4] = (Button) findViewById(R.id.five);  
      BoardButtons[5] = (Button) findViewById(R.id.six);  
      BoardButtons[6] = (Button) findViewById(R.id.seven);  
      BoardButtons[7] = (Button) findViewById(R.id.eight);  
      BoardButtons[8] = (Button) findViewById(R.id.nine);  
      
      
      playAgainButton=(Button) findViewById(R.id.Play_again_button);
      
      
      //for the sound
      mp=MediaPlayer.create(this, R.raw.human);
      mp2=MediaPlayer.create(this, R.raw.win);
      mp3=MediaPlayer.create(this, R.raw.lost);
      mp4=MediaPlayer.create(this, R.raw.tie);
      mp5=MediaPlayer.create(this, R.raw.play_again_click);
      
      
      playAgainButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
			if(GameOver==true)
			{	
				//for sound
				if(SoundActivity.sound_selector!=1)
				{
					mp5.start();
				}
				
			 startNewGame();  
			GameOver=false;
			}
		}
	});
      
      
      
        
      InfoTextView = (TextView) findViewById(R.id.information);  
      HumanCount = (TextView) findViewById(R.id.humanCount);  
      TieCount = (TextView) findViewById(R.id.tiesCount);  
      AndroidCount = (TextView) findViewById(R.id.androidCount);  
        
      HumanCount.setText(Integer.toString(HumanCounter));  
      TieCount.setText(Integer.toString(TieCounter));  
      AndroidCount.setText(Integer.toString(AndroidCounter));  
        
      Game = new TicTacToeGame();  
        
      startNewGame();  
        
    }  
      
    private void startNewGame()  
    {  
    	for(int i=0;i<=8;i++)
    	
    	BoardButtons[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon5));
		/*BoardButtons[1].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon5));
		BoardButtons[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon5));
		BoardButtons[3].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon5));
		BoardButtons[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon5));
		BoardButtons[5].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon5));
		BoardButtons[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon5));
		BoardButtons[7].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon5));
		BoardButtons[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon5));*/
    	
         Game.clearBoard();  
           
         for (int i = 0; i < BoardButtons.length; i++)  
         {  
              BoardButtons[i].setText("");  
              BoardButtons[i].setEnabled(true);  
              BoardButtons[i].setOnClickListener(new ButtonClickListener(i));  
         }  
           
         if (HumanFirst)  
         {  
             InfoTextView.setText(R.string.first_human);  
              HumanFirst = false;  
         }  
         else  
         {  
              InfoTextView.setText(R.string.turn_computer);  
              int move = Game.androidMove();  
              setMove(Game.ANDROID_PLAYER, move);  
              HumanFirst = true;  
         }  
    }  
      
    private class ButtonClickListener implements View.OnClickListener  
    {  
         int location;  
           
         public ButtonClickListener(int location)  
         {  
              this.location = location;  
         }  
          
         public void onClick(View view)  
         {  
              if (!GameOver)  
              {  
                  if (BoardButtons[location].isEnabled())  
                   {  
                        setMove(Game.HUMAN_PLAYER, location);  
                          
                        int winner = Game.WinnerDecider();
                        int hard_winner=Game.hard();
                          
                        if (winner == 0)  
                        {  
                        	if(hard_winner==5)
                        	{
                        		setMove(Game.ANDROID_PLAYER, 4);
                        		
                        		
                        		  //for sound
                        		 if(SoundActivity.sound_selector!=1)
                        		 {
                                mp.start();
                        		 }
                        	}
                        	else
                        	{
                             InfoTextView.setText(R.string.turn_human);  
                             int move = Game.androidMove();  
                             setMove(Game.ANDROID_PLAYER, move);
                             
                             
                             //for sound
                             if(SoundActivity.sound_selector!=1)
                             {
                             mp.start();
                             }
                             
                             winner = Game.WinnerDecider();  
                        	}
                        }  
                          
                        if (winner == 0) 
                        {
                             InfoTextView.setText(R.string.turn_human);
                             
                             //for sound
                             if(SoundActivity.sound_selector!=1)
                             {
                             mp.start();
                             }
                        }
                        else if (winner == 1)  
                        {  
                             InfoTextView.setText(R.string.result_tie);  
                             
                             
                             
                             //for sound
                             if(SoundActivity.sound_selector!=1)
                             {
                             mp4.start();
                             }
                             
                             
                             TieCounter++;  
                             TieCount.setText(Integer.toString(TieCounter));  
                             GameOver = true;  
                        }  
                        else if (winner == 2)  
                        {  
                             InfoTextView.setText(R.string.result_human_wins);
                             
                             
                             //for sound
                             if(SoundActivity.sound_selector!=1)
                             {
                             mp2.start();
                             }
                             
                             
                             HumanCounter++;  
                             HumanCount.setText(Integer.toString(HumanCounter));  
                             GameOver = true;  
                             
                             
                             //for winning line
                             winningLine();
                             
                        }  
                        else  
                        {  
                             InfoTextView.setText(R.string.result_android_wins); 
                             
                             
                             //for sound
                             if(SoundActivity.sound_selector!=1)
                             {
                             mp3.start();
                             }
                             
                             
                             
                             AndroidCounter++;  
                             AndroidCount.setText(Integer.toString(AndroidCounter));  
                             GameOver = true;
                             
                             
                             
                             //for winning line
                             winningLine();
                             
                        }  
                   }  
              }  
         }  
    }  
      
    
	@SuppressWarnings("deprecation")
	private void setMove(char player, int location)  
    {  
         Game.setMove(player, location);  
         BoardButtons[location].setEnabled(false);  
         //mBoardButtons[location].setText(String.valueOf(player));  
         
         
         
         if (player == Game.HUMAN_PLAYER)  
         {
        	 if(SelecticonActivity.icon_selector==1)
        	 
              BoardButtons[location].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon1));
              
        	 else 
        		 BoardButtons[location].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon2));
         }
              
              else  
              {
            	  
            	  if(SelecticonActivity.icon_selector2==3)
                 	 
                      BoardButtons[location].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon3));
                      
                	 else
                		 BoardButtons[location].setBackgroundDrawable(getResources().getDrawable(R.drawable.icon4));	  
        	
              }
         
         
    }  
	
	
	
	
	private void winningLine()
    {
    	//for the winning line
        if(GameOver)
        {
      	   int winner = Game.WinnerDecider();  
      	  if(winner==2)
      	  {
      		  //for horizontal check(player 1)
      		  for(int i=0;i<=6;i+=3)
      		  {
      			  
      			  if(Game.Board[i]==Game.HUMAN_PLAYER&&
      				Game.Board[i+1]==Game.HUMAN_PLAYER&&
      				Game.Board[i+2]==Game.HUMAN_PLAYER)
      			  {
      				 if(SelecticonActivity.icon_selector==1)
         			  {
         				  BoardButtons[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon1));
         				  BoardButtons[i+1].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon1));
         				  BoardButtons[i+2].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon1));
         			  }
         			  
         			  else
         			  {
         				  BoardButtons[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon5));
         				  BoardButtons[i+1].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon5));
         				  BoardButtons[i+2].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon5));
         			  } 
      			  }
      			  
      			  
      			 
      		  }
      		  
      		  
      		  
      		  //for vertical check(player 1)
      		  for(int i=0;i<=2;i++)
      		  {
      			  if(Game.Board[i]==Game.HUMAN_PLAYER&&
      					Game.Board[i+3]==Game.HUMAN_PLAYER&&
      					Game.Board[i+6]==Game.HUMAN_PLAYER)
      			  {
      				  if(SelecticonActivity.icon_selector==1)
      				  {
      					  BoardButtons[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon2));
      					 BoardButtons[i+3].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon2));
      					 BoardButtons[i+6].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon2));
      				  }
      				  
      				  else
      				  {
      					BoardButtons[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon6));
     					 BoardButtons[i+3].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon6));
     					 BoardButtons[i+6].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon6));  
      				  }
      			  }
      		  }
      		  
      		  
      		  
      		  //for diagonal check from left(player 1)
      		  if(Game.Board[0]==Game.HUMAN_PLAYER&&
      				Game.Board[4]==Game.HUMAN_PLAYER&&
      				Game.Board[8]==Game.HUMAN_PLAYER)
      		  {
      			  if(SelecticonActivity.icon_selector==1)
      			  {
      				  BoardButtons[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon3));
      				 BoardButtons[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon3));
      				 BoardButtons[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon3));
      			  }
      			  
      			  else
      			  {
      				BoardButtons[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon7));
     				 BoardButtons[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon7));
     				 BoardButtons[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon7));
      			  }
      		  }
      		  
      		  
      		  
      		  
      		 
      		  //for diagonal check from right(player 1)
      		  if(Game.Board[2]==Game.HUMAN_PLAYER&&
      				Game.Board[4]==Game.HUMAN_PLAYER&&
      				Game.Board[6]==Game.HUMAN_PLAYER)
      		  {
      			  if(SelecticonActivity.icon_selector==1)
      			  {
      				  BoardButtons[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon4));
      				 BoardButtons[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon4));
      				 BoardButtons[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon4));
      			  }
      			  
      			  else
      			  {
      				BoardButtons[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon8));
     				 BoardButtons[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon8));
     				 BoardButtons[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon8));
      			  }
      		  }//1
      		  
      		  
      		  
      	  }
      	  
      	  
      	  
      	  if(winner==3)
      	  {
      		  
      		 //for horizontal check(player 2)
      		  for(int i=0;i<=6;i+=3)
      		  {
      			  
      			  if(Game.Board[i]==Game.ANDROID_PLAYER&&
      				Game.Board[i+1]==Game.ANDROID_PLAYER&&
      				Game.Board[i+2]==Game.ANDROID_PLAYER)
      			  {
      				 if(SelecticonActivity.icon_selector2==3)
         			  {
         				  BoardButtons[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon9));
         				  BoardButtons[i+1].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon9));
         				  BoardButtons[i+2].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon9));
         			  }
         			  
         			  else
         			  {
         				  BoardButtons[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon13));
         				  BoardButtons[i+1].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon13));
         				  BoardButtons[i+2].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon13));
         			  } 
      			  }
      			  
      			  
      			 
      		  }
      		  
      		  
      		  
      		  //for vertical check(player 2)
      		  for(int i=0;i<=2;i++)
      		  {
      			  if(Game.Board[i]==Game.ANDROID_PLAYER&&
      					Game.Board[i+3]==Game.ANDROID_PLAYER&&
      					Game.Board[i+6]==Game.ANDROID_PLAYER)
      			  {
      				  if(SelecticonActivity.icon_selector2==3)
      				  {
      					  BoardButtons[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon10));
      					 BoardButtons[i+3].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon10));
      					 BoardButtons[i+6].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon10));
      				  }
      				  
      				  else
      				  {
      					BoardButtons[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon14));
     					 BoardButtons[i+3].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon14));
     					 BoardButtons[i+6].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon14));  
      				  }
      			  }
      		  }
      		  
      		  
      		  
      		  //for diagonal check from left(player 2)
      		  if(Game.Board[0]==Game.ANDROID_PLAYER&&
      				Game.Board[4]==Game.ANDROID_PLAYER&&
      				Game.Board[8]==Game.ANDROID_PLAYER)
      		  {
      			  if(SelecticonActivity.icon_selector2==3)
      			  {
      				  BoardButtons[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon11));
      				 BoardButtons[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon11));
      				 BoardButtons[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon11));
      			  }
      			  
      			  else
      			  {
      				BoardButtons[0].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon15));
     				 BoardButtons[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon15));
     				 BoardButtons[8].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon15));
      			  }
      		  }
      		  
      		  
      		  
      		  
      		 
      		  //for diagonal check from right(player 2)
      		  if(Game.Board[2]==Game.ANDROID_PLAYER&&
      				Game.Board[4]==Game.ANDROID_PLAYER&&
      				Game.Board[6]==Game.ANDROID_PLAYER)
      		  {
      			  if(SelecticonActivity.icon_selector2==3)
      			  {
      				  BoardButtons[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon12));
      				 BoardButtons[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon12));
      				 BoardButtons[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon12));
      			  }
      			  
      			  else
      			  {
      				BoardButtons[2].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon16));
     				 BoardButtons[4].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon16));
     				 BoardButtons[6].setBackgroundDrawable(getResources().getDrawable(R.drawable.winning_icon16));
      			  }
      		  }//1
      		  
      		  
      	  }
      	  
      	  
      	  
        }
        //for the winning line
        
    }
    
	
	
	
	
	
	
	
  }  