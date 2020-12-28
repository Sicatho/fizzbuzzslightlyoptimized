/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the basic room class
 ****************************************************************/
package UFOWars;

import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

//Creates a room
public class Room extends Pane {
    private ArrayList<Character> ch = new ArrayList<>();
    private final Timeline time;
    public int numObjects, rmIndex;
    private double mouseX, mouseY;
    boolean check;
    public Room() {
        numObjects = 0;
        check = false;
        time = new Timeline(
        new KeyFrame(Duration.millis(60), e -> playGame()));
        time.setCycleCount(Timeline.INDEFINITE);
    }
    
    
    public void runRoom(){
        time.play();
    }
    
    public void addCharacter(Character c) {
        ch.add(c);
        getChildren().add(ch.get(numObjects).get());
        ch.get(numObjects).numInst = numObjects;
        numObjects++;
    }
    protected void playGame() {
                for (int i = 0; i < numObjects;i++) {
                ch.get(i).step();
                this.setOnMouseClicked(mouseEvent);
            }
            setEvents();
    }
    public void setEvents() {
            
            
    }

  public void pause() {
    time.pause();
  }

  public void setSpeed(double rate) {
    time.setRate(rate);
  }

    public void instanceDestroy(int numObject){
        getChildren().remove(ch.get(numObject).get());
        ch.remove(ch.get(numObject));
        decrementAllIndexes(numObject);
        numObjects--;
        
        //
    }
    public Node getInstance(int numObject) {
        return getChar(numObject);
    }
    
    private void decrementAllIndexes(int numObject) {
        for (int i = 0; i < (ch.size()-numObject);i++) {
        ch.get(numObject+i).numInst--;
        }
    }
    
    public Node getChar(int chNum) {
    return ch.get(chNum).get();
    }
    
    public double getMouseX() {
        this.setOnMouseMoved(mousePos);
        return mouseX;
    }
    public double getMouseY() {
        this.setOnMouseMoved(mousePos);
        return mouseY;
    }
    private boolean checkReset() {
        if (check) {
            check = false;
            return true;
        } else {
            return false;
        }
    }
    
    public void mouseClicked() {
        
    }
    
    public boolean keyPressed(KeyCode key) {
        
        this.setOnKeyPressed(e -> {
            if (e.getCode() == key) {
                check = true;
            }
        });
                return checkReset();
    }
    
    
    EventHandler<MouseEvent> mouseEvent = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //check = true;
                //System.out.println("hi");
                
                for (int i = 0; i < numObjects;i++) {
                    ch.get(i).mouseLeftClicked();
                    mouseClicked();
                }
                
            }
        };
    EventHandler<MouseEvent> mousePos = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                mouseX = event.getX();
                mouseY = event.getY();
                //System.out.println(mouseX + " " + mouseY);
            }
        };
    EventHandler<KeyEvent> keyEvent = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
           
        }
    };

    
}
