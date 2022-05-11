package wordSearch.view;

import wordSearch.controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HighScoreUI extends JPanel implements ActionListener 
{
    public JLabel label;
    private String panelName;
    private HighScoreController controller;
    ArrayList<JLabel> labels;

	public HighScoreUI(HighScoreController controller, String panelName)
	{
        this.controller = controller;
        this.panelName = panelName;
        labels = new ArrayList<JLabel>();


        for (String score : controller.getHighScores())
        {
            label = new JLabel(score + "  ");
            this.labels.add(label);
            this.add(label);
        }

		this.setPreferredSize(new Dimension(200, 300));
        BoxLayout boxlayout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(boxlayout);
        this.setBorder(BorderFactory.createTitledBorder(this.panelName)); 
	}

    public JLabel getLabel()
    {
        return this.label;
    }

    public void actionPerformed(ActionEvent e)
    {
        this.controller.showHighScores();
    }
}