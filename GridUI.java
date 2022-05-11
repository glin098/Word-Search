package wordSearch.view;

import wordSearch.controller.*;
import java.awt.*;   
import javax.swing.*;
import java.util.ArrayList;

public class GridUI extends JPanel 
{  
   protected JLabel label;
   protected int width = 500;
   protected int height = 500;
   protected GridBagConstraints constraints = new GridBagConstraints();
   protected boolean isSelected = false;
   public WordSearchController controller;
   public WordBankUI bank;

   ArrayList<LetterButton> buttons;

   public GridUI(WordSearchController controller, WordBankUI bank)
   {  
      this.controller = controller;
      this.bank = bank;

      int size = controller.getGridSize();
      
      this.setPreferredSize(new Dimension(300, 300));
      this.setLayout(new GridLayout(size, size));  

      buttons = new ArrayList<LetterButton>();

      for (int r = 0; r < size; r++) 
      { 
         for (int c = 0; c < size; c++) 
         { 
            LetterButton jb = new LetterButton(this, controller, r, c);
            buttons.add(jb);
            this.add(jb);
         }
      }
   }

   public void disableButtons()
   {
      for (LetterButton b : this.buttons)
      {
         for (int row : controller.getSelectedRows())
         {
            for (int col : controller.getSelectedColumns())
            {
               if (b.getRow() == row && b.getColumn() == col)
               {
                  b.setEnabled(false);
               }
            }
         }
         
      }
      this.bank.changeColor(this.controller.getFoundWord());
   }
}
