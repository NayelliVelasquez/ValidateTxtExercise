import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;

/**
 * Class to read txt file.
 **/
public class ReadFileTxt {
 /**
  * Method to read File. 
   */ 
  public void readFile() {
    List<String> words = new ArrayList<String>();
    BufferedReader br = null;
    try {
      String strCurrentLine;
      br = new BufferedReader(new FileReader("words.txt")); // Source of the txt file to read.

      while ((strCurrentLine = br.readLine()) != null) { // Reads each line with a word.

        words.add(strCurrentLine); // add all the words to the List.
      }

      Collections.sort(words, (a, b) -> b.length() - a.length()); // Obtains the sorted list by length.
      String word = null;
      for (int i = 0; i < words.size(); i++) { // Iterative of the list by each word.
        word = words.get(i);
        String wordUse = word;

        for (int j = i + 1; j < words.size() && !"".equals(wordUse); j++) { // Comparing by the size and different to empty.
          String wordSecond = words.get(j);
          if (word.contains(wordSecond)) { //Validates the word contains in the following word.
            wordUse = wordUse.replaceAll(wordSecond, "");
          }

        }
        if (wordUse.isEmpty()) {
          break;

        }

      }
      System.out.println(word);

    } catch (IOException e) {
      System.out.println("An error occurred to Read File.");
      e.printStackTrace();
    } finally {
      if (br != null) { //Validation for the closure of the file.
        try {
          br.close(); //Close our file txt.
        } catch (IOException e) { //Exceptions
          System.out.println("Error to close file");
          e.printStackTrace();
        }

      }

    }
  }

}