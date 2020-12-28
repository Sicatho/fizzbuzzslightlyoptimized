
package UFOWars;/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the second room
 ****************************************************************/

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

class RoomTwo extends Room {
    //Initialize and declare variables
    private TextField tf;
    private Score score;
    //Constructor
    public RoomTwo() {
        super();
        tf = new TextField();
        score = new Score();
    }
    
    //Field to enter name
    public void setTextField() {
        tf.setAlignment(Pos.CENTER);
        tf.setFont(Font.font("PressStart2P"));
        tf.setText("Enter your name");
        tf.setPrefColumnCount(10);
        tf.getText();
        
        getChildren().add(tf);
        this.setTranslateX(450);
        this.setTranslateY(360);
        this.runRoom();
    }
    public Score getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score.setScore(score);
    }
    @Override
    public void mouseClicked() {
        score.setName(tf.getText());
    }
    
    
    
}