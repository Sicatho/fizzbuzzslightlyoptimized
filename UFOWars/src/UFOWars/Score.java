/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the actual score of the player, and their name
 ****************************************************************/
package UFOWars;

import java.io.Serializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Score implements Comparable<Score>, Serializable {
    //Initialize and declare variables
    private String name;
    private int score;
    private transient Text text;
    //Constructor
    public Score() {
        this.name = "___";
        this.score = -1;  
    }
    
    //Setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public Text getText() {
        return text;
    }

    public void setTextString(String string) {
        text = new Text();
        text.setText(toString());
        text.setFill(Color.WHITE);
        text.setFont(Font.font("PressStart2P",30));
        text.setText(this.toString());
    }
    
    public void setTextSelf() {
        setTextString(toString());
    }
    //Override compareto to be able to sort the scores
    @Override
    public int compareTo(Score sc){ 
        if(this.getScore() > sc.getScore()) return 1; 
        if(this.getScore() < sc.getScore()) return -1;
        else                   return 0;
    }
    @Override
    public String toString() {
        return getName() + "    has a score of  " + getScore();
    }
}
