package wordSearch.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

public class ScoreList implements Serializable 
{
    protected ArrayList<Score> highScores;
    protected String saveName;
    private boolean autoSave;
    int highScore = 0;

    public ScoreList(String saveName, boolean autoSave)
    {
        this.highScores = new ArrayList<Score>();
        this.saveName = saveName;
        this.autoSave = autoSave;
    }

    public void add(Score score)
    {
        this.highScores.add(score);
    }

    private void sort(){
        this.highScores.sort(new Comparator<Score>()
        {
            @Override
            public int compare(Score score1, Score score2){
                Integer int1 = score1.getTime();
                Integer int2 = score2.getTime();
                return int1.compareTo(int2);
            }
        });
    }

    public boolean addScore(Score score)
    {
        if(this.highScores.size() < 10)
        {
            this.highScores.add(score);
            sort();
            if(autoSave)
            {
                save();
            }
            return true;
        }

        Score lowestScore = this.highScores.get(0);
        if (score.getTime() > lowestScore.getTime()) 
        {
            this.highScores.remove(lowestScore);
            this.highScores.add(score);
            sort();
            if (autoSave) 
            {
                save();
            }
            return true;
        }
        return false;
    }

    public void save() 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveName))) 
        {
            oos.writeObject(this);
        } catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public String getScore() 
    {
        StringBuilder returnValue = new StringBuilder();

        for (Score score : this.highScores) 
        {
            returnValue.append(score.getName());
            returnValue.append(",");
            returnValue.append(score.getTime());
            returnValue.append("\n");
        }
        return returnValue.toString();
    }
}