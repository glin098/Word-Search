package wordSearch.controller;

import wordSearch.model.*;
import java.util.ArrayList;

public class WordSearchController 
{
    private WordBankLoader word;
    public Grid grid;
    private WordBankInterface wordBankUI;

    private ArrayList<Integer> currentSelectedRows; 
    private ArrayList<Integer> currentSelectedColumns;

    public WordSearchController(WordBankLoader word, Grid grid) 
    {
        this.word = word;
        this.grid = grid;

        this.currentSelectedRows = new ArrayList<Integer>();
        this.currentSelectedColumns = new ArrayList<Integer>();
    }

    public Grid getGrid()
    {
        return this.grid;
    }

    public int getGridSize()
    {
        return this.grid.getSize();
    }

    public char getLetterAt(int row, int column)
    {
        return this.grid.getLetter(row, column);
    }

    public ArrayList<String> getBank()
    {
        return this.word.getItems();
    }

    public void addSelected(int rowNum, int colNum)
    {
        this.currentSelectedRows.add(rowNum);
        this.currentSelectedColumns.add(colNum);
    }

    public void removeSelected(int rowNum, int colNum)
    {
        this.currentSelectedRows.remove(Integer.valueOf(rowNum));
        this.currentSelectedColumns.remove(Integer.valueOf(colNum));
    }

    public ArrayList<Integer> getSelectedRows()
    {
        return this.currentSelectedRows;
    }

    public ArrayList<Integer> getSelectedColumns()
    {
        return this.currentSelectedColumns;
    }

    public void resetSelected()
    {
        this.currentSelectedRows = new ArrayList<Integer>();
        this.currentSelectedColumns = new ArrayList<Integer>();
    }

    public void showWordBank()
    {
        ArrayList<String> allWords = new ArrayList<String>();
        for (String word : this.word.getItems())
        {
            allWords.add(word);
        }

        wordBankUI.showWordBank(allWords);
    }

    public void addWordBankInterface(WordBankInterface ui)
    {
        this.wordBankUI = ui;
    }

    public boolean matches()
    {
        if (this.grid.isPlayable(this.currentSelectedRows, this.currentSelectedColumns) == true)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    
    public String getFoundWord()
    {
        return this.grid.foundWord();
    }

    public boolean allWordsFound()
    {
        System.out.println("YOU WON!");
        return true;
    }
}