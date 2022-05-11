package wordSearch.model;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordBankLoaderCSV extends WordBankLoader 
{
      
    String fileName;
    ArrayList<String> words;

    public WordBankLoaderCSV(String fileName)
   {
      this.fileName = fileName;
      words = new ArrayList<String>();
   }

   public void loadItems() throws IOException 
   {
      BufferedReader buffread = new BufferedReader(new FileReader(this.fileName));
      String line = "";
      while ( (line = buffread.readLine()) != null)
      {
        String[] parts = line.split(",");
        for (String item : parts)
        {
           this.words.add(item);
        }
      }
     buffread.close();
   }

   public ArrayList<String> getItems()
   {
      return this.words;
   }
}
