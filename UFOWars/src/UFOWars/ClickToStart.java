/*****************************************************************
File:           PuzzleGame.java
Names:          Tristan Suppan, Waqar Khaliq, Usman Siddiqui
Date:           12/11/17
Description:    This is the first text that can be clicked to start the game
 ****************************************************************/

package UFOWars;

class ClickToStart extends Character {
    //Initialize and declare variables
    RoomList rl;
    public ClickToStart(String s, double x, double y, double fitX, double fitY, RoomList rl) {
        super(s, x, y, fitX, fitY);
        this.rl = rl;
    }
    //If clicked, change room
    @Override
    public void mouseLeftClicked() {
        rl.rmGotoNext();
    }
}