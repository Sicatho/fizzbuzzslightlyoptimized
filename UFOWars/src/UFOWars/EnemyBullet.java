/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the flying enemy's bullet
 ****************************************************************/
package UFOWars;

import javafx.scene.paint.Color;

class EnemyBullet extends Character {
    //Initialize and declare variables
    private double rad;
    private RoomOne rm;
    private double dx, dy;
    private int distance = 30;
    
    //Constructor
    public EnemyBullet(double rad, double x, double y, RoomOne rm, double dx,double dy) {
        super(rad,x,y);
        this.rad = rad;
        this.rm = rm;
        this.dx = dx;
        this.dy = dy;
        cir.setFill(Color.YELLOW);
    }
    
    //Deletes if moved a certain distance
    @Override
    public void step() {
        distance--;
        if (distance < 0){
            rm.instanceDestroy(this.numInst);
        }
    
    setPos(getX() + dx,getY()+dy);
    
    
}
}
