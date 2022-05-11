package wordSearch.view;

import wordSearch.controller.*;
import java.awt.*;   
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class LetterButton extends JButton implements ActionListener 
{
    boolean selected = false;
    GridUI ui;
    int row;
    int column;
    WordSearchController controller;
    Border unselectedBorder;
    Border selectedBorder;

    public LetterButton(GridUI ui, WordSearchController controller, int row, int column)
    {
        super(String.valueOf(controller.getLetterAt(row,column)));
        this.ui = ui;
        this.row = row;
        this.column = column;
        this.controller = controller;

        this.addActionListener(this);
        this.setOpaque(true);
        this.unselectedBorder = this.getBorder();
        this.selectedBorder = BorderFactory.createLineBorder(Color.GREEN, 1);
    }

    public int getRow()
    {
        return this.row;
    }

    public int getColumn()
    {
        return this.column;
    }

    public void actionPerformed(ActionEvent e) 
    {
        this.selected = !this.selected;

       if (this.selected)
       {
            this.setBorder(selectedBorder);
            controller.addSelected(this.row, this.column);
            if (controller.matches() == true)
            {
                ui.disableButtons();
                controller.resetSelected();
            }
       }
       else 
       {
            this.setBorder(unselectedBorder);
            controller.removeSelected(this.row, this.column);
       }
       
    }
}
