package wordSearch.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HighScoreLoaderCSV 
{
    public ArrayList<Score> highScores = new ArrayList<Score>();

    public HighScoreLoader loadScores() throws IOException
    {

        BufferedReader buffread1 = new BufferedReader(new FileReader("easyHighScores.csv"));
        BufferedReader buffread2 = new BufferedReader(new FileReader("mediumHighScores.csv"));
        BufferedReader buffread3 = new BufferedReader(new FileReader("hardHighScores.csv"));

        String line;
        
        while ((line = buffread1.readLine()) != null)
        {
            String[] parts = line.split(",");

            if (parts.length == 2)
            {

                Score score = new Score(parts[0], Integer.valueOf(parts[1]));
                highScores.add(score);

            }
        }

        buffread1.close();

        while ((line = buffread2.readLine()) != null)
        {
            String[] parts = line.split(",");
            if (parts.length == 2)
            {   

                Score score = new Score(parts[0], Integer.valueOf(parts[1]));
                highScores.add(score);

            }
        }

        buffread2.close();

        while ((line = buffread3.readLine()) != null)
        {
            String[] parts = line.split(",");
            if (parts.length == 2)
            {
                Score score = new Score(parts[0], Integer.valueOf(parts[1]));
                highScores.add(score);

            }
        }

        buffread3.close();

        ArrayList<String> scores = new ArrayList<String>();

        for(Score s : highScores)
        {
            scores.add(s.name + " " + s.time);
        }
        HighScoreLoader output = new HighScoreLoader();
        output.setScore(scores);
        return output;
    }
}