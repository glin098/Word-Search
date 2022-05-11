package wordSearch.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Grid 
{
    protected int columns; 
    protected int rows;    
    protected int min = 0;      
    protected int max;     
    protected char[][] grid;
    protected ArrayList<Word> words;
    protected String found;

    public Grid(int gridSize, ArrayList<String> bank)
    {
        this.columns = gridSize;
        this.rows = gridSize;
        this.max = (gridSize - 1);
        this.grid = new char[this.rows][this.columns];
        this.words = new ArrayList<Word>(); 

        char[] abc = {'A','B', 'C', 'D', 'E', 'F', 'G', 'H', 'I','J', 'K', 'L',
             'M', 'N', 'O', 'P','Q','R','S','T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

     
        // creates word objects for each dictionary word
        for (int i = 0; i < bank.size(); i++) 
        {
            Random r = new Random();
            Word w = new Word(bank.get(i), bank.get(i).length(), min + r.nextInt(max - min + 1), min + r.nextInt(max - min + 1));
            this.words.add(w);
        } 

        // start overlap stuff
        // Collections.sort(this.words, new Comparator<Word>() 
        // {
        // 	public int compare(Word wordOne, Word wordTwo) 
        //     {
        // 		return wordOne.row - ((Word)wordTwo).getRow();
        // 	}
    
        // });       
        
        // Collections.sort(this.words, new Comparator<Word>() 
        // {
        //     public int compare(Word wordOne, Word wordTwo) 
        //     {
        //         if(wordOne.getRow() == 0) 
        //         {
        //             wordOne.setRow(wordOne.getRow()+1);
        //         }
        //         if(wordTwo.getRow() == 0) 
        //         {
        //             wordTwo.setRow(wordTwo.getRow()+1);
        //         }
        //         if (wordOne.row == wordTwo.row) 
        //         {
        //             if(wordTwo.getRow() == rows) 
        //             {
        //                 wordTwo.setRow(0);
        //             }
        //             wordTwo.setRow(wordTwo.getRow()+1);
        //         }
        //         return wordOne.row - ((Word)wordTwo).getRow();
        //     }
        // });    


        // for (int o = 0; o < this.words.size(); o++) {
        //     for (int i = 0; i < this.words.size(); i++) 
        //     {
        //         if (i % 2 != 0) {
        //             int col = this.words.get(i).getColumn();
        //             int nextCol = this.words.get(i+1).getColumn();

        //             if(col == nextCol || col > nextCol) {
        //                 int nextWordSize = this.words.get(i+1).getSize();
        //                 int newColPlacement = nextCol+nextWordSize;
                      
        //                 if(newColPlacement > rows) {
        //                     newColPlacement = 0;
        //                 }
        //                 this.words.get(i).setColumn(newColPlacement);
        //             }                

        //         }
        //     } 
        // } 

         // end overlap stuff
    
         
        // stores info & randomized location to word object
        for (int i = 0; i < words.size(); i++) 
        {
            String name = words.get(i).getName();
            int wordSize = words.get(i).getSize();
            int row = words.get(i).getRow();
            int column = words.get(i).getColumn();

            if (i % 2 == 0)
            {
                // makes sure word stays in bounds of grid
                if ((column + wordSize) > max) 
                    {
                        int colDifference = column + wordSize - max;
                        words.get(i).setColumn(column - colDifference);
                    }
                int newColumn = words.get(i).getColumn();

                for (int r = 0; r < wordSize; r++) // horizontal
                {
                    this.grid[row][newColumn] = name.charAt(r); 
                    words.get(i).setAllRows(row);
                    words.get(i).setAllColumns(newColumn);
                    newColumn++;
                }
            }
            else 
            {
                // makes sure word stays in bounds of grid
                if ((row + wordSize) > max)
                {
                    int rowDifference = row + wordSize - max;
                    words.get(i).setRow(row - rowDifference);
                }
                int newRow = words.get(i).getRow();

                for (int c = 0; c < wordSize; c++) // vertical
                {   
                    this.grid[newRow][column] = name.charAt(c);
                    words.get(i).setAllRows(newRow);
                    words.get(i).setAllColumns(column);
                    newRow++;
                }
            }
            
        }

        // adds random letters to empty spots in grid
        for (int r = 0; r < grid.length; r++) 
        { 
            for (int c = 0; c < grid[r].length; c++)
            {
                if (grid[r][c] == 0)
                {
                    Random randomInt = new Random();
                    grid[r][c] = abc[randomInt.nextInt(abc.length)]; 
                }
            }
        }

    }

    public char[][] getGrid()
    {
        return this.grid;
    }

    public int getSize()
    {
        return this.columns;
    }

    public char getLetter(int row, int column)
    {
        return this.grid[row][column];
    }

    public boolean isPlayable(ArrayList<Integer> rows, ArrayList<Integer> cols)
    {
        Collections.sort(rows);
        Collections.sort(cols);

        for (Word word : words)
        {
            if (word.getAllRows().equals(rows) && word.getAllColumns().equals(cols))
            {
                this.found = new String(word.getName());
                this.foundWord();
                return true;
            }
        }
        return false;
    }

    public String foundWord()
    {
        return this.found;
    }
}
