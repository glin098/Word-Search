package wordSearch.view;

import wordSearch.controller.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class FrontScreen implements ActionListener
{
    JFrame mainFrame;
    JPanel mainPanel;
    JLabel welcomeLabel;
    JLabel rules1Label;
    JLabel rules2Label;
    JLabel spacer;
    JButton easyButton, mediumButton, hardButton, highScoreButton, quitButton;
    GridBagConstraints constraints = new GridBagConstraints();

    int width = 500;
    int height = 300;

    public FrontScreen()
    {
       // frame & panel 
       this.mainFrame = new JFrame("Jungle Word Search");
       this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       this.mainPanel = new JPanel();
       this.mainPanel.setPreferredSize(new Dimension(this.width, this.height));
       this.mainPanel.setLayout(new GridBagLayout());

        // heading
        this.welcomeLabel = new JLabel("Welcome to Jungle Word Search!");
        constraints.gridx = 1;
        constraints.gridy = 0;
        this.mainPanel.add(this.welcomeLabel, constraints);

        this.rules1Label = new JLabel("To play, find all words listed in the word bank");
        constraints.gridx = 1;
        constraints.gridy = 1;
        this.mainPanel.add(this.rules1Label, constraints);

        this.rules2Label = new JLabel("and select the words on the grid by clicking the tiles.");
        constraints.gridx = 1;
        constraints.gridy = 2;
        this.mainPanel.add(this.rules2Label, constraints);

        this.spacer = new JLabel("    ");
        constraints.gridx = 1;
        constraints.gridy = 3;
        this.mainPanel.add(spacer, constraints);

        // difficulty buttons 
        this.easyButton = new JButton("Easy");
        constraints.gridx = 0;
        constraints.gridy = 4;
        this.easyButton.addActionListener(this);
        this.mainPanel.add(this.easyButton, constraints);

        this.mediumButton = new JButton("Medium");
        constraints.gridx = 1;
        constraints.gridy = 4;
        this.mediumButton.addActionListener(this);
        this.mainPanel.add(this.mediumButton, constraints);

        this.hardButton = new JButton("Hard");
        constraints.gridx = 2;
        constraints.gridy = 4;
        this.hardButton.addActionListener(this);
        this.mainPanel.add(this.hardButton, constraints);

        // highscore & quit buttons
        this.highScoreButton = new JButton("Show High Scores");
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        this.highScoreButton.addActionListener(this);
        this.mainPanel.add(this.highScoreButton, constraints);

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

    // connect buttons to listeners
    public void setOnEasy(ActionListener l)
    {
        easyButton.addActionListener(l);
    }

    public void setOnMedium(ActionListener l)
    {
        mediumButton.addActionListener(l);
    }

    public void setOnHard(ActionListener l)
    {
        hardButton.addActionListener(l);
    }

    public void setOnHighScore(ActionListener l)
    {
        highScoreButton.addActionListener(l);
    }
  
    public void actionPerformed(ActionEvent e)
    {

       easyButton.setEnabled(false);
       mediumButton.setEnabled(false);
       hardButton.setEnabled(false);
       highScoreButton.setEnabled(false);
       quitButton.setEnabled(false);

       this.mainPanel.repaint();
    }
}
