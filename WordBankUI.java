package wordSearch.view;

import wordSearch.controller.WordSearchController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
 
public class WordBankUI extends JPanel implements ActionListener
{
    private JLabel jb;
    private WordSearchController controller;
    ArrayList<JLabel> labels;
    private int counter;

	public WordBankUI(WordSearchController controller)
	{
        this.controller = controller;
        this.labels = new ArrayList<JLabel>();
        this.counter = 0;

        for (String word : controller.getBank())
        {
            jb = new JLabel("  " + word + "  ");
            this.labels.add(jb);
            this.add(jb);
        }

		this.setPreferredSize(new Dimension(200, 300));
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(boxlayout);
        this.setBorder(BorderFactory.createTitledBorder("WORD BANK"));   
	}

    public void changeColor(String name)
    {
        for (JLabel word : labels)
        {
            if (word.getText().equals("  " + name + "  "))
            {
                word.setForeground(Color.GREEN);
                word.repaint();
            }
        }
        this.counter++;
        
        if (this.counter == this.labels.size())
        {
            this.controller.allWordsFound();
        }
    }

    private void clearFields()
    {
        this.jb.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.controller.showWordBank();
        clearFields();
    }
}
