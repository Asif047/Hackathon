package com.asiftanmoy.tictactoe;

import java.util.Random;  

import android.R.color;
    
  public class TicTacToeGame {  
         
        char Board[];  
      private final static int BOARD_SIZE = 9;  
         
       public static final char HUMAN_PLAYER = 'X';  
       public static final char ANDROID_PLAYER = '0';
       
       public static final char PLAYER_ONE = 'X';  
       public static final char PLAYER_TWO = '0';  
       
       public static final char EMPTY_SPACE = ' ';  
         
       private Random Rand;  
         
       public static int getBOARD_SIZE() {  
            return BOARD_SIZE;  
       }  
         
       public TicTacToeGame(){  
             
            Board = new char[BOARD_SIZE];  
             
            for (int i = 0; i < BOARD_SIZE; i++)  
                 Board[i] = EMPTY_SPACE;  
              
            Rand = new Random();  
       }  
         
       public void clearBoard()  
       {  
            for (int i = 0; i < BOARD_SIZE; i++)  
            {  
                 Board[i] = EMPTY_SPACE; 
                 
            }  
       }  
         
       public void setMove(char player, int location)  
       {  
            Board[location] = player;  
       }  
         
       public int androidMove()  
       {  
            int move;  
              
            for (int i = 0; i < getBOARD_SIZE(); i++)  
            {  
                 if (Board[i] != HUMAN_PLAYER && Board[i] != ANDROID_PLAYER)  
                 {  
                     char curr = Board[i];  
                      Board[i] = ANDROID_PLAYER;  
                      if (WinnerDecider() == 3)  
                      {  
                           setMove(ANDROID_PLAYER, i);  
                           return i;  
                      }  
                      else  
                           Board[i] = curr;  
                 }  
            }  
              
            for (int i = 0; i < getBOARD_SIZE(); i++)  
            {  
                 if (Board[i] != HUMAN_PLAYER && Board[i] != ANDROID_PLAYER)  
                 {  
                      char curr = Board[i];  
                      Board[i] = HUMAN_PLAYER;  
                      if (WinnerDecider() == 2)  
                      {  
                           setMove(ANDROID_PLAYER, i);  
                           return i;  
                      }  
                      else  
                           Board[i] = curr;  
                 }  
            }  
             
            do  
            {  
                 move = Rand.nextInt(getBOARD_SIZE());  
            } while (Board[move] == HUMAN_PLAYER || Board[move] == ANDROID_PLAYER);  
                   
                 setMove(ANDROID_PLAYER, move);  
            return move;  
       }  
       
       
       
       
       //this method is for easy level
       public int androidMoveEasy()  
       {  
            int move;  
             
           for (int i = 0; i < getBOARD_SIZE(); i++)  
            {  
                 if (Board[i] != HUMAN_PLAYER && Board[i] != ANDROID_PLAYER)  
                 {  
                     char curr = Board[i];  
                      Board[i] = ANDROID_PLAYER;  
                      if (WinnerDecider() == 3)  
                      {  
                           setMove(ANDROID_PLAYER, i);  
                           return i;  
                      }  
                      else  
                           Board[i] = curr;  
                 }  
            } 
           
             /* 
            for (int i = 0; i < getBOARD_SIZE(); i++)  
            {  
                 if (mBoard[i] != HUMAN_PLAYER && mBoard[i] != ANDROID_PLAYER)  
                 {  
                      char curr = mBoard[i];  
                      mBoard[i] = HUMAN_PLAYER;  
                      if (checkForWinner() == 2)  
                      {  
                           setMove(ANDROID_PLAYER, i);  
                           return i;  
                      }  
                      else  
                           mBoard[i] = curr;  
                 }  
            } */ 
             
            do  
            {  
                 move = Rand.nextInt(getBOARD_SIZE());  
            } while (Board[move] == HUMAN_PLAYER || Board[move] == ANDROID_PLAYER);  
                   
                 setMove(ANDROID_PLAYER, move);  
            return move;  
       }  
       
       //end of the method geComputerMoveEasy
       
       
       
       
       
       
         
       public int WinnerDecider()  
       {  
            for (int i = 0; i <= 6; i += 3)  
            {  
                 if (Board[i] == HUMAN_PLAYER &&  
                   Board[i+1] == HUMAN_PLAYER &&  
                   Board[i+2] == HUMAN_PLAYER)  
                      return 2;  
                 if (Board[i] == ANDROID_PLAYER &&  
                      Board[i+1] == ANDROID_PLAYER &&  
                      Board[i+2] == ANDROID_PLAYER)  
                      return 3;  
            }  
              
            for (int i = 0; i <= 2; i++)  
            {  
                 if (Board[i] == HUMAN_PLAYER &&  
                      Board[i+3] == HUMAN_PLAYER &&  
                      Board[i+6] == HUMAN_PLAYER)  
                      return 2;  
                if (Board[i] == ANDROID_PLAYER &&  
                      Board[i+3] == ANDROID_PLAYER &&  
                      Board[i+6] == ANDROID_PLAYER)  
                      return 3;  
            }  
              
            if ((Board[0] == HUMAN_PLAYER &&  
                  Board[4] == HUMAN_PLAYER &&  
                  Board[8] == HUMAN_PLAYER) ||  
                  Board[2] == HUMAN_PLAYER &&  
                  Board[4] == HUMAN_PLAYER &&  
                  Board[6] == HUMAN_PLAYER)  
                  return 2;  
            if ((Board[0] == ANDROID_PLAYER &&  
                  Board[4] == ANDROID_PLAYER &&  
                  Board[8] == ANDROID_PLAYER) ||  
                  Board[2] == ANDROID_PLAYER &&  
                  Board[4] == ANDROID_PLAYER &&  
                  Board[6] == ANDROID_PLAYER)  
                  return 3;  
              
            for (int i = 0; i < getBOARD_SIZE(); i++)  
            {  
                 if (Board[i] != HUMAN_PLAYER && Board[i] != ANDROID_PLAYER)  
                      return 0;  
            }  
              
            return 1;  
       }  
       
       
       
       public int hard()
       {
    	   if(Board[0]==HUMAN_PLAYER&&	   
    		 Board[1]==EMPTY_SPACE&&
    		 Board[2]==EMPTY_SPACE&&
    		 Board[3]==EMPTY_SPACE&&
    		 Board[4]==EMPTY_SPACE&&
    		 Board[5]==EMPTY_SPACE&&
    		 Board[6]==EMPTY_SPACE&&
    		 Board[7]==EMPTY_SPACE&&
    		 Board[8]==EMPTY_SPACE||
    		 
    			   
    		 Board[2]==HUMAN_PLAYER&&	   
    		 Board[1]==EMPTY_SPACE&&
    		 Board[0]==EMPTY_SPACE&&
    		 Board[3]==EMPTY_SPACE&&
    		 Board[4]==EMPTY_SPACE&&
    		 Board[5]==EMPTY_SPACE&&
    		 Board[6]==EMPTY_SPACE&&
    		 Board[7]==EMPTY_SPACE&&
    		 Board[8]==EMPTY_SPACE|| 
    		 
    		 
    		 
    		 Board[6]==HUMAN_PLAYER&&	   
    		 Board[1]==EMPTY_SPACE&&
    		 Board[0]==EMPTY_SPACE&&
    		 Board[3]==EMPTY_SPACE&&
    		 Board[4]==EMPTY_SPACE&&
    		 Board[5]==EMPTY_SPACE&&
    		 Board[2]==EMPTY_SPACE&&
    		 Board[7]==EMPTY_SPACE&&
    		 Board[8]==EMPTY_SPACE||
    		 
    		 
    		 
    		 Board[8]==HUMAN_PLAYER&&	   
    		 Board[1]==EMPTY_SPACE&&
    		 Board[0]==EMPTY_SPACE&&
    		 Board[3]==EMPTY_SPACE&&
    		 Board[4]==EMPTY_SPACE&&
    		 Board[5]==EMPTY_SPACE&&
    		 Board[2]==EMPTY_SPACE&&
    		 Board[7]==EMPTY_SPACE&&
    		 Board[6]==EMPTY_SPACE
    			   
    		 )
    		   
    		 
		return 5;
    	   
    	   else
		return 10;
    		   
       }
       
       
  }  