/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the flying enemy that shoots bullets
 ****************************************************************/
package UFOWars;

import javafx.scene.paint.Color;

class Enemy extends Character {
    //Initialize and declare variables
    private double rad;
    private RoomOne rm;
    private double dx, dy;
    private int time;
    public boolean invincible;
    public Enemy(double rad, double x, double y, RoomOne rm, double spd) {
        super(rad,x,y);
        this.rad = rad;
        this.rm = rm;
        dx = dy = spd;
        cir.setFill(Color.RED);
        time = 30;
        invincible = false;
    }
    
    //Bouncing enemies
    @Override
    public void step() {
    
    if (getX() < rad || x > rm.getWidth() - rad) {
      dx *= -1;
    }
    if (y < rad || y > rm.getHeight() - rad) {
      dy *= -1;
    }
    setPos(getX() + dx,getY()+dy);
    
    time--;
    
    if (time <=0) {
        invincible = true;
        time = 30;
        rm.addEnemyBullet(new EnemyBullet(10,x,y+20,rm,0,20));
        rm.addEnemyBullet(new EnemyBullet(10,x,y-20,rm,0,-20));
        rm.addEnemyBullet(new EnemyBullet(10,x+20,y,rm,20,0));
        rm.addEnemyBullet(new EnemyBullet(10,x-20,y,rm, -20,0));
    } else {
        invincible = false;
    }
    
    
}
}