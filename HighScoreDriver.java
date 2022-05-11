package wordSearch;

import wordSearch.view.*;
import wordSearch.controller.*;
import wordSearch.model.*;

import java.io.IOException;

public class HighScoreDriver
{
    String fileName;

    HighScoreController controller;

    public HighScoreDriver(String name)
    {
        this.fileName = name;
    }
    
    public void start()
    {
        HighScoreLoaderCSV loader = new HighScoreLoaderCSV();
        try
        {
            loader.loadScores();
        }
        catch (IOException io)
        {
            System.out.println("Could not load high score files");
            return;
        }

        //this.controller = new HighScoreController(loader);

        HighScoreUI highScoreUI = new HighScoreUI(controller, "easyHighScores");
        HighScoreScreen highScoreScreen = new HighScoreScreen(highScoreUI);
    }

    public HighScoreController getController()
    {
        return this.controller;
    }

}
