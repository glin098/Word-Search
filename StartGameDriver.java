package wordSearch;

import wordSearch.view.*;
import wordSearch.controller.*;
import wordSearch.model.*;

import java.io.IOException;

public class StartGameDriver
{
    String fileName;
    int gridSize;

    WordSearchController controller;

    public StartGameDriver(String name, int size)
    {
        this.fileName = name;
        this.gridSize = size;
    }
    
    public void start()
    {
        WordBankLoaderCSV loader = new WordBankLoaderCSV(this.fileName);
        try
        {
            loader.loadItems();
            
        }
        catch (IOException io)
        {
            System.out.println("Could not load dictionary");
            return;
        }

        // instantiates everything needed for panel
        Grid grid = new Grid(this.gridSize, loader.getItems());

        this.controller = new WordSearchController(loader, grid);

        WordBankUI bankui = new WordBankUI(controller);

        GridUI gui = new GridUI(controller, bankui);

        Stopwatch timer = new Stopwatch();
        timer.start();  

        
        // creates main game panel 
        WordSearchPanel searchPanel = new WordSearchPanel(gui, bankui, timer);

        // testing only
        // grid.printLocations();
    }

    public WordSearchController getController()
    {
        return this.controller;
    }

}
