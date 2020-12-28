/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is a bullet fired by the player
 ****************************************************************/
package UFOWars;

import javafx.scene.paint.Color;

public class Bullet extends Character {
    //Initialize and declare variables
        private RoomOne rm;
        private double spd;
        double xMove, yMove, dist;
        private int distance = 50;
        
        //Constructer
        public Bullet(double x, double y, RoomOne rm, double spd, double xMove, double yMove) {
            
        super(10, x, y);
        this.rm = rm;
        this.spd = spd;
        this.xMove = xMove-this.x;
        this.yMove = yMove-this.y;
        this.cir.setFill(Color.CHARTREUSE);
       }
        
        //Checks every game tick
        @Override
        public void step() {
        distance--;
        if (distance < 0){
            rm.instanceDestroy(this.numInst);
        }
        for(int i = 0; i < rm.getEnemyCount(); i++) {
            if(characterMeeting(x, y, rm.getEnemies(i))) {
               if (!rm.getEnemies(i).invincible) {
               rm.destroyEnemy(i);
               rm.instanceDestroy(this.numInst);
               }
            }
        }
        //Movement
        dist = Math.sqrt((xMove*xMove)+(yMove*yMove));
        xMove = spd*Math.cos(Math.acos(xMove/dist));
        yMove = spd*Math.sin(Math.asin(yMove/dist));
            setX(getX()+xMove);
            setY(getY()+yMove);
        }
}