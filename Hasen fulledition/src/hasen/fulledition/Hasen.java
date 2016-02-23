/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasen.fulledition;

import frameapi.*;
import static hasen.fulledition.Hasen.moveHasen;

/**
 *
 * @author yannick.fuchs
 */
public class Hasen {
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String [][] meinArray = new String [14][14];
       Spielfeldbauen(meinArray);
       FrameAPI.initFrame();
       FrameAPI.initString(meinArray.length, meinArray); 
       FrameAPI.setPlayground();
       
       do {
           if(FrameAPI.newRound) {
           moveHasen(meinArray);
           FrameAPI.initString(meinArray.length, meinArray);
           FrameAPI.setPlayground();  
           
           
           }
       }
       while(!FrameAPI.allDead);
           

    
    
       }
       
        
    
   public static void Spielfeldbauen(String[][]meinArray)
   {
            for(int i=0; i<meinArray.length; i++)
        {
             
           for(int j=0; j<meinArray.length; j++)
            {
             meinArray[i][j]=".";
            }
        }  
        
        meinArray[3][9]=   "H";   
        meinArray[8][4]=   "H";
        meinArray[5][10]=  "H";
        meinArray[12][9]=  "H";
        meinArray[10][8]= "H";
        meinArray[1][2]=   "H";
        meinArray[4][7]=   "F";
        meinArray[12][2]=  "F";
        meinArray[7][8]=   "F";
        
   }
   public static void moveHasen(String[][]Spielfeld)
   {
          
       String[][] Speicher = new String[14][14];
        for(int i=0; i<14; i++)
        {
            for(int j=0; j<14; j++)
            {
            Speicher[i][j]= Spielfeld[i][j];
            }
        }
               
         for(int i=0; i<14; i++)
        {
             
           for(int j=0;j<14; j++){
            
             if(Speicher[i][j].equals("H"))
        {
             Spielfeld[i][j]=".";
             Spielfeld[i][j+1]="H";
        }
            }
        }  
   }   
}
