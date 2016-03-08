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
    public static void main(String[] args)                                        //Hauptausführung
    {
       String [][] meinArray = new String [14][14];
       Spielfeldbauen(meinArray);
       FrameAPI.initFrame();
       FrameAPI.initString(meinArray.length, meinArray); 
       FrameAPI.setPlayground();
       
       do{
           if(FrameAPI.newRound) 
           {
           moveHasen(meinArray);
           FrameAPI.initString(meinArray.length, meinArray);
           FrameAPI.setPlayground();  
           }
         }
       while(!FrameAPI.allDead);                                                // Bis alle Hasen tot sind
    }
    
   public static void Spielfeldbauen(String[][]meinArray)                       // Spielfeld wird aufgebaut
   {
        for(int i=0; i<meinArray.length; i++)
        {
          for(int j=0; j<meinArray.length; j++)
            {
             meinArray[i][j]=".";
            }
        }  
        meinArray[3][9]=   "F";                                                 //Hasen und Füchse definieren
        meinArray[8][4]=   "H";
        meinArray[5][10]=  "H";
        meinArray[9][9]=   "F";
        meinArray[10][8]=  "H";
        meinArray[2][2]=   "H";
        meinArray[2][4]=   "F";
        meinArray[10][2]=  "F";
        meinArray[7][8]=   "H";
        meinArray[7][10]=  "F";
        meinArray[9][12]=  "F";
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
        }                                                                        //externes Spielfeld wird aufgebaut
               
        for(int i=0; i<14; i++)
        {
             
           for(int j=0;j<14; j++)
           {
            if(Speicher[i][j].equals("F"))                                      //Bewegung vom Fuchs nach rechts
               {
                Spielfeld[i][j]=".";
                Spielfeld[i][j+1]="F";
               }
            if(Spielfeld[i][13].equals("F"))                                    //Fuchs wird vom Ende des Feldes zum anderen gespawnt
               {
                Spielfeld[i][j]=".";
                Spielfeld[i][0]="F";
               }
            if(Speicher[i][j].equals("H"))                                      //Bewegung von Hasen nach rechts und nach unten
               {  
                Spielfeld[i][j]=".";
                Spielfeld[i+1][j+1]="H";
               }
            if(Spielfeld[13][j].equals("H"))                                    //Hase wird am Ende des Feldes zum anderen gespawnt
               {
                Spielfeld[i][j]=".";
                Spielfeld[0][j]="H";
               } 
            if(Spielfeld[i][13].equals("H"))                                    //Hase wird am Ende des Feldes zum anderen gespawnt
               {
                Spielfeld[i][j]=".";
                Spielfeld[i][0]="H";
               }
            }
        }
   }   
}
