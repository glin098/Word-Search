package wordSearch.view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class HighScoreScreen extends JPanel implements ActionListener
{
    JFrame mainFrame;
    JPanel mainPanel;
    JLabel highScoreLabel;
    JButton playAgainButton, quitButton;
    GridBagConstraints constraints = new GridBagConstraints();
    int width = 500;
    int height = 300;

    HighScoreUI highScores;

    public HighScoreScreen(HighScoreUI highScores)
    {
        this.highScores = highScores;

       // frame & panel 
       this.mainFrame = new JFrame("High Scores");
       this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       this.mainPanel = new JPanel();
       this.mainPanel.setPreferredSize(new Dimension(this.width, this.height));
       this.mainPanel.setLayout(new GridBagLayout());

        // heading
        this.highScoreLabel = new JLabel("HIGH SCORES");
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.mainPanel.add(this.highScoreLabel, constraints);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.mainPanel.add(highScores, constraints);
        highScores.setPreferredSize(new Dimension(500, 500));

        this.playAgainButton = new JButton("PLAY AGAIN");
        constraints.gridx = 0;
        constraints.gridy = 6;
        this.playAgainButton.addActionListener(this);
        this.mainPanel.add(this.playAgainButton, constraints);

        this.quitButton = new JButton("QUIT");
        constraints.gridx = 0;
        constraints.gridy = 7;
        this.quitButton.addActionListener(this);
        this.mainPanel.add(this.quitButton, constraints);
        quitButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        
        // add panel to main frame
        this.mainFrame.add(this.mainPanel);
        this.mainFrame.pack();
        this.mainFrame.setVisible(true);
    }
  
    public void actionPerformed(ActionEvent e)
    {
        quitButton.setEnabled(false);
        playAgainButton.setEnabled(true);
        this.mainPanel.repaint();
    }

}