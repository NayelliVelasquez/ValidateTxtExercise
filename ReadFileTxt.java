import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.*;

/**
 * Class to read txt file.
 **/
public class ReadFileTxt {
  private String fileName;
  private List<String> words;

  //Constructor of ReadFileTxt.
  public ReadFileTxt(String fileName) {
    this.fileName = fileName;
    this.words = new ArrayList<>();

  }

  /**
   * Method to obtain the longest compound word.
   */
  public void obtainLongestCompound() {
    readTxt();
   
    Collections.sort(words, (w1, w2) -> w2.length() - w1.length()); // Obtains the sorted list by length.
    StringBuilder builder = new StringBuilder();
    String longestWord = null; //Initiation of variables.
    int wordsFound = 0;
    boolean isFoundFirst = false;
    Set<String> set = new HashSet<String>();
    for (String word : words) //Iteration of words.
      set.add(word);

    for (String word : words) {
      for (int i = 0; i < word.length(); i++) {
        for (int j = i; j < word.length(); j++) {
          String subWord = word.substring(i, j + 1);
          if (set.contains(subWord) && !subWord.equals(word)) {
            builder.append(subWord);
            i = j;
            break;
          }
        }
      }
      if (builder.toString().equals(word)) {
        wordsFound++;
        if (!isFoundFirst) {

          longestWord = word;
          isFoundFirst = true;
        }
      }
      
      builder.delete(0, builder.length());

    }

    System.out.println("The longest word is:" +longestWord);
    System.out.println("Number of words: " +wordsFound);
  }


  /**
   * Method to read File.
   */
  public void readTxt() {
    BufferedReader br = null;

    try {
      String strCurrentLine;
      br = new BufferedReader(new FileReader(fileName)); // Source of the txt file to read.

      while ((strCurrentLine = br.readLine()) != null) { // Reads each line with a word.

        words.add(strCurrentLine); // add all the words to the List.
      }

    } catch (IOException e) {
      System.out.println("An error occurred to Read File.");
      e.printStackTrace();
    } finally {
      if (br != null) { // Validation for the closure of the file.
        try {
          br.close(); // Close our file txt.
        } catch (IOException e) { // Exceptions
          System.out.println("Error to close file");
          e.printStackTrace();
        }

      }
    }

  }
}