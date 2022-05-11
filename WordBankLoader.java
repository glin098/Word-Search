package wordSearch.model;

import java.util.ArrayList;

public class WordBankLoader 
{
    protected ArrayList<String> words;

    public WordBankLoader()
    {
        this.words = new ArrayList<String>();
    }

    public ArrayList<String> getItems()
    {
        return this.words;
    }
    
}
