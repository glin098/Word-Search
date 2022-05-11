package wordSearch.model;

import java.io.Serializable;

public class Score implements Serializable 
{
    protected String name;
    protected int time;

    public Score(String name, int time)
    {
        this.name = name;
        this.time = time;
    }

    public String getName()
    {
        return this.name;
    }

    public int getTime()
    {
        return this.time;
    }
}