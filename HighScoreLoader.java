package wordSearch.model;

import java.util.ArrayList;

public class HighScoreLoader 
{
    public ArrayList<String> scores;

    public HighScoreLoader()
    {
        this.scores = new ArrayList<String>();
    }

    public ArrayList<String> getScores()
    {
        return this.scores;
    }

    public void setScore(ArrayList<String> scores)
    {
        this.scores = scores;
    }
}
