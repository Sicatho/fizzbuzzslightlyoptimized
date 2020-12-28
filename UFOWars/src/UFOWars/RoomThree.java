/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the third room
 ****************************************************************/
package UFOWars;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class RoomThree extends Room implements Serializable {
    //Initialize and declare variables
    private ArrayList<Score> sc = new ArrayList<>(10);
    FileScore file;
    private boolean fileExists;
    //Constructor
    public RoomThree() {
        super();
        File tmpDir = new File("scoreList.dat");
        fileExists = tmpDir.exists();
        for (int i = 0; i < 10; i++) {
            sc.add(new Score());
        }
        
    }
    
    //Scoreboard functions
    public void addScore(Score score) {
        if (fileExists) {
            file = new FileScore("scoreList");
            sc = file.getScoreList();
        } else {
            file = new FileScore("scoreList");
        }
        if (sc.size() <= 10) {
            sc.add(score);
        } else {
            for (int i = 0; i < sc.size(); i++) {
                if (sc.get(i).compareTo(score) == -1) {
                    sc.add(score);
                    break;
                }
            }
        }
        Collections.sort(sc);
        Collections.reverse(sc);
        if (sc.size() == 11) {
                sc.remove(10);
            }
        
        for (int i = 0; i < sc.size(); i++) {
            sc.get(i).setTextString(sc.get(i).toString());
            sc.get(i).getText().setX(200);
            sc.get(i).getText().setY(60*i+150);
            getChildren().add(sc.get(i).getText());
        }
            file.addScoreList(sc);
    }
}