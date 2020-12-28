/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the class that keeps tract of the score and saves it to a file
 ****************************************************************/
package UFOWars;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class FileScore implements Serializable {
    //Initialize and declare variables
    private ArrayList<Score> sc = new ArrayList<>();
    private String fileName;
    
    
    public FileScore(String fileName) {
    this.fileName = fileName + ".dat";
    }
    public void writeScore() {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream output = new ObjectOutputStream(fileOut);
            output.writeObject(sc);//Writes to the file
            output.close();
            fileOut.close();
      } catch (IOException e) {
          System.out.println("ERROR! File not written correctly!"+e);
      }
  }
    public void readScore() {
         try {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
            sc = ((ArrayList<Score>)input.readObject());
            input.close();
    } catch (Exception ex) {
        System.out.println("ERROR" + ex);
    }
    }
    public void addScore(Score score) {
        this.sc.add(score);
    }
    public Score getScore(int scoreNum) {
        return this.sc.get(scoreNum);
    }
    
    public void addScoreList(ArrayList<Score> sc) {
        this.sc = sc;
        writeScore();
    }
    
    public ArrayList<Score> getScoreList() {
            readScore();
            return sc;
    }
}
