/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is an object to run objects that don't show up
 ****************************************************************/
package UFOWars;

import java.util.Random;

class Controller extends NullCharacter {
    //Initialize and declare variables
    RoomOne rm;
    Random rand;
    double randNum;
    public Controller(RoomOne rm) {
        this.rm = rm;
        rand = new Random();
        randNum = .98;
    }
    
    //Spawn enemies
    @Override
    public void step() {
        if (rand.nextDouble() > randNum) {
        rm.addEnemy(new Enemy(20,1000*rand.nextDouble()+40,640*rand.nextDouble()+40,rm,12));
        if (randNum > .9)
        randNum -= .002;
        
        }
        
        
    }
    
}
