

//this activity is for TWO PLAYER MODE

package com.asiftanmoy.tictactoe;

import android.app.Activity;  
import android.graphics.Color;  
import android.media.MediaPlayer;
import android.os.Bundle;  
import android.view.View;  
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;  
import android.widget.TextView;  
    
    
  public class TicTacToeActivity2 extends Activity {  
         
	  
	  Button playAgainButton2;
	  
	  //for the sound
	  MediaPlayer mp;
	  MediaPlayer mp2;
	  MediaPlayer mp3;
	  MediaPlayer mp4;
	  MediaPlayer mp5;
	  
	  
	  
	  
       private TicTacToeGame Game;  
         
       private Button BoardButtons[];  
         
       private TextView InfoTextView;  
       private TextView PlayerOneCount;  
       private TextView TieCount;  
      private TextView PlayerTwoCount;
      
      
      private TextView PlayerOneText;
      private TextView PlayerTwoText;
         
       private int PlayerOneCounter = 0;  
       private int TieCounter = 0;  
       private int PlayerTwoCounter = 0;  
         
       private boolean HumanFirst = true;  
       private boolean GameOver = false;  
         
       
       private boolean IsPlayerOneTurn=true;
    /** Called when the activity is first created. */  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
      super.onCreate(savedInstanceState);  
      
      
      
      //removing the title
      requestWindowFeature(Window.FEATURE_NO_TITLE);
      
      
      setContentView(R.layout.activity_tic_tac_toe_activity2);  
        
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
        
      
      playAgainButton2=(Button) findViewById(R.id.Play_again_button2);
      
      
      
      
      
      
    
      
      
      
      
      
      //for the sound
      mp=MediaPlayer.create(this, R.raw.human);
      mp2=MediaPlayer.create(this, R.raw.win);
      mp3=MediaPlayer.create(this, R.raw.lost);
      mp4=MediaPlayer.create(this, R.raw.tie);
      mp5=MediaPlayer.create(this, R.raw.play_again_click);
      
      
      playAgainButton2.setOnClickListener(new OnClickListener() {
  		
  		@Override
  		public void onClick(View v) {
  			// TODO Auto-generated method stub
  			
  			if(GameOver==true)
  			{
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
      PlayerOneCount = (TextView) findViewById(R.id.humanCount);  
      TieCount = (TextView) findViewById(R.id.tiesCount);  
      PlayerTwoCount = (TextView) findViewById(R.id.androidCount); 
      
      
     // mPlayerOneText=(TextView) findViewById(R.id.player_one);
     // mPlayerTwoText=(TextView) findViewById(R.id.player_two);
        
      PlayerOneCount.setText(Integer.toString(PlayerOneCounter));  
      TieCount.setText(Integer.toString(TieCounter));  
      PlayerTwoCount.setText(Integer.toString(PlayerTwoCounter));  
        
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
           
         if (IsPlayerOneTurn)  
         {  
             InfoTextView.setText(R.string.turn_player_one);  
             // IsPlayerOneTurn = false;  
         }  
         else  
         {  
              InfoTextView.setText(R.string.turn_player_Two);  
           
             //IsPlayerOneTurn = true;  
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
                	  if(IsPlayerOneTurn)
                        setMove(Game.PLAYER_ONE, location); 
                	  else
                		  setMove(Game.PLAYER_TWO, location); 
                          
                        int winner = Game.WinnerDecider();  
                          
                        if (winner == 0)  
                        {  
                        	if(IsPlayerOneTurn)
                        	{
                             InfoTextView.setText(R.string.turn_player_Two); 
                             
                             
                             //for sound
                             if(SoundActivity.sound_selector!=1)
                             {
                             mp.start();
                             }
                             
                             
                             IsPlayerOneTurn=false;
                        	}
                        	
                        	else
                        		
                        	{
                                InfoTextView.setText(R.string.turn_player_one); 
                                
                                
                                //for sound
                                if(SoundActivity.sound_selector!=1)
                                {
                                mp.start();
                                }
                                
                                
                                IsPlayerOneTurn=true;
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
                             
                             
                             
                           //for changing turn
                             if(IsPlayerOneTurn)
                            	 IsPlayerOneTurn=false;
                             else
                            	 IsPlayerOneTurn=true;
                             
                             
                        }  
                        else if (winner == 2)  
                        {  
                             InfoTextView.setText(R.string.result_player_one_wins); 
                             
                             
                             
                             //for sound
                             if(SoundActivity.sound_selector!=1)
                             {
                             mp2.start();
                             }
                             
                             
                             PlayerOneCounter++;  
                             PlayerOneCount.setText(Integer.toString(PlayerOneCounter));  
                             GameOver = true;  
                             
                             
                             
                             //for the winning line
                             winningLine();
                             
                             //for changing turn
                             if(IsPlayerOneTurn)
                            	 IsPlayerOneTurn=false;
                             else
                            	 IsPlayerOneTurn=true;
                             
                        }  
                        else  
                        {  
                             InfoTextView.setText(R.string.result_player_two_wins);
                             
                             
                             //for sound
                             if(SoundActivity.sound_selector!=1)
                             {
                             mp2.start();
                             }
                             
                             
                             PlayerTwoCounter++;  
                             PlayerTwoCount.setText(Integer.toString(PlayerTwoCounter));  
                             GameOver = true;  
                             
                             
                             //for the winning line
                             winningLine();
                             
                             
                           //for changing turn
                             if(IsPlayerOneTurn)
                            	 IsPlayerOneTurn=false;
                             else
                            	 IsPlayerOneTurn=true;
                        }  
                   }  
              } 
              
              
       
              
         }  
    }  
      
    
    
    private void setMove(char player, int location)  
    {  
         Game.setMove(player, location);  
         BoardButtons[location].setEnabled(false);  
         //mBoardButtons[location].setText(String.valueOf(player));  
         
         
         
         if (player == Game.PLAYER_ONE)  
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
      			  
      			  if(Game.Board[i]==Game.PLAYER_ONE&&
      				Game.Board[i+1]==Game.PLAYER_ONE&&
      				Game.Board[i+2]==Game.PLAYER_ONE)
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
      			  if(Game.Board[i]==Game.PLAYER_ONE&&
      					Game.Board[i+3]==Game.PLAYER_ONE&&
      					Game.Board[i+6]==Game.PLAYER_ONE)
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
      		  if(Game.Board[0]==Game.PLAYER_ONE&&
      				Game.Board[4]==Game.PLAYER_ONE&&
      				Game.Board[8]==Game.PLAYER_ONE)
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
      		  if(Game.Board[2]==Game.PLAYER_ONE&&
      				Game.Board[4]==Game.PLAYER_ONE&&
      				Game.Board[6]==Game.PLAYER_ONE)
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
      			  
      			  if(Game.Board[i]==Game.PLAYER_TWO&&
      				Game.Board[i+1]==Game.PLAYER_TWO&&
      				Game.Board[i+2]==Game.PLAYER_TWO)
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
      			  if(Game.Board[i]==Game.PLAYER_TWO&&
      					Game.Board[i+3]==Game.PLAYER_TWO&&
      					Game.Board[i+6]==Game.PLAYER_TWO)
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
      		  if(Game.Board[0]==Game.PLAYER_TWO&&
      				Game.Board[4]==Game.PLAYER_TWO&&
      				Game.Board[8]==Game.PLAYER_TWO)
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
      		  if(Game.Board[2]==Game.PLAYER_TWO&&
      				Game.Board[4]==Game.PLAYER_TWO&&
      				Game.Board[6]==Game.PLAYER_TWO)
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