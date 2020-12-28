/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the class for the player character
 ****************************************************************/
package UFOWars;

import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Plr extends Character {
    //Initialize and declare variables
    RoomOne rm;
    RoomList rl;
    RoomTwo rm2;
    double mouseX;
    double mouseY;
    double distMouse, xMove,yMove;
    int numBullets;
    ArrayList<Enemy> en;
    int hp = 100;
    double spd;
    Rectangle redRec, greenRec;
    
    //Constructor
    public Plr(double rad, double x, double y, RoomOne rm, RoomList rl) {
        
        super(rad, x, y);
        this.rm = (RoomOne) rl.getRoom(2);
        this.rm2 = (RoomTwo) rl.getRoom(1);
        this.rl = rl;
        numBullets = 3;
        spd = 12;
        cir.setFill(Color.CORNFLOWERBLUE);
        greenRec = new Rectangle(50,50,100,30);
        greenRec.setFill(Color.GREEN);
        redRec = new Rectangle(50,50,100,30);
        redRec.setFill(Color.RED);
        rm.getChildren().addAll(redRec,greenRec);
        
    }
    //Move to mouse, and get hit by bullets
    @Override
    public void step() {
        moveToPoint(rm.getMouseX(),rm.getMouseY(), 12);
        
        
        for(int i = 0; i < rm.getEnemyBulletCount(); i++) { 
        if(characterMeeting(x, y, rm.getEnemyBullet(i))) {
           hp-= 10;
           rm.destroyEnemyBullet(i);
        }
        }
        if(hp <= 0) {
            rl.rmGotoNext();
            rm2.setTextField();
            rm2.setScore(rm.getScore());
            DoneBtn done = new DoneBtn("done.png",-25,50,200,100, rl);
            rm2.addCharacter(done);
            hp = 100;
        }
        greenRec.setWidth(hp);
        
    }
    
    //Shooting
    @Override
    public void mouseLeftClicked() {
        rm.addCharacter(new Bullet(x,y, rm, 30, rm.getMouseX(),rm.getMouseY()));
         
    }
        
}