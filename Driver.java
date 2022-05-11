package wordSearch;

import wordSearch.view.*;
import wordSearch.controller.*;

import wordSearch.model.*;
import java.awt.event.*;

import java.io.IOException;

public class Driver
{
    public static void main(String []args)
    {
        FrontScreen home = new FrontScreen();
	    
        home.setOnEasy(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                StartGameDriver game = new StartGameDriver("easyDictionary.csv", 10);
                game.start();
            }
        }); 

        home.setOnMedium(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                StartGameDriver game = new StartGameDriver("mediumDictionary.csv", 20);
                game.start();
            }
        }); 

        home.setOnHard(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                StartGameDriver game = new StartGameDriver("hardDictionary.csv", 30);
                game.start();
            }
        }); 

        home.setOnHighScore(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                HighScoreLoaderCSV load = new HighScoreLoaderCSV();
                HighScoreLoader out = new HighScoreLoader();
                try{
                    out = load.loadScores();

                }
                catch (IOException io) {

                }

                // for(String o : out.getScores()){
                //     System.out.println(o);
                // }
                
                HighScoreController control = new HighScoreController(out);
                HighScoreUI  ui = new HighScoreUI(control, "test");
                HighScoreScreen screen = new HighScoreScreen(ui);
                // System.out.println("high score button pressed");
            }
        }); 
    }
}
