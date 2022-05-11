package wordSearch.controller;

import wordSearch.model.*;
import java.util.ArrayList;

public class HighScoreController 
{
    private HighScoreLoader scores;
    private HighScoreInterface highScoreUI;

    public HighScoreController(HighScoreLoader scores)
    {
        this.scores = scores;
    }

    public ArrayList<String> getHighScores()
    {
        return this.scores.getScores();
    }

    public void showHighScores()
    {
        ArrayList<String> allScores = new ArrayList<String>();
        for (String word : this.scores.getScores())
        {
            allScores.add(word);
        }
        highScoreUI.showHighScores(allScores);
    }
}
