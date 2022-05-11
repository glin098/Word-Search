package wordSearch.view;

import javax.swing.*;
import java.awt.*;
import java.awt.GridBagConstraints;
 
public class WordSearchPanel extends JPanel
{
	JFrame mainFrame;
   	WordBankUI wordBank;
  	GridUI grid;
  	GridBagConstraints constraints = new GridBagConstraints();
	Stopwatch stopwatch;
    
    public WordSearchPanel(GridUI grid, WordBankUI bank, Stopwatch stopwatch)
    {
		this.grid = grid;
		this.wordBank = bank;
		this.stopwatch = stopwatch;

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		mainFrame = new JFrame("Jungle Word Search");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(new Dimension(800, 800));
	
		this.add(stopwatch);
		this.add(grid);
		this.add(wordBank);
		wordBank.setPreferredSize(new Dimension(500, 100));
		
		mainFrame.getContentPane().add(this);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}  
