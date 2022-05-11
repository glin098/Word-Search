package wordSearch.model;
import java.util.ArrayList;
import java.util.Collections;

public class Word 
{
    public String name; 
    public int size;  
    public int row;  
    public int column;
    public ArrayList<Integer> allRows;
    public ArrayList<Integer> allColumns;

    public Word(String name, int size, int row, int column)
    {
        this.name = name;
        this.size = size;
        this.row = row;
        this.column = column;

        this.allRows = new ArrayList<Integer>();
        this.allColumns = new ArrayList<Integer>();
    }

    public String getName() 
    { 
        return this.name;
    }

    public int getSize() 
    { 
        return this.size;
    }

    public int getRow() 
    { 
        return this.row;
    }

    public void setRow(int i) 
    { 
        this.row = i;
    }

    public int getColumn() 
    { 
        return this.column;
    }

    public void setColumn(int i) 
    { 
        this.column = i;
    }

    public ArrayList<Integer> getAllRows()
    {
        Collections.sort(this.allRows);
        return this.allRows;
    }

    public void setAllRows(int rowNum)
    {
        this.allRows.add(rowNum);
    }

    public ArrayList<Integer> getAllColumns()
    {
        Collections.sort(this.allColumns);
        return this.allColumns;
    }

    public void setAllColumns(int colNum)
    {
        this.allColumns.add(colNum);
    }

}
